package br.com.luisbovo.ohescolhedor.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.errorContainerLightMediumContrast
import com.example.compose.onPrimaryLight
import com.example.compose.primaryContainerLight
import com.example.compose.primaryLight
import com.example.compose.tertiaryContainerLight
import com.example.compose.tertiaryLight
import me.nikhilchaudhari.quarks.CreateParticles
import me.nikhilchaudhari.quarks.particle.Acceleration
import me.nikhilchaudhari.quarks.particle.EmissionType
import me.nikhilchaudhari.quarks.particle.Force
import me.nikhilchaudhari.quarks.particle.LifeTime
import me.nikhilchaudhari.quarks.particle.ParticleColor
import me.nikhilchaudhari.quarks.particle.ParticleSize
import me.nikhilchaudhari.quarks.particle.Velocity

@Composable
fun Confetti(
    modifier:Modifier = Modifier,
            durationMillis:Int = 4000
) {
    CreateParticles(
        modifier = modifier,
        x = 500f, y = -200f,
        velocity = Velocity(xDirection = 2f, yDirection = -2f, randomize = true),
        force = Force.Gravity(0.3f),
        acceleration = Acceleration(),
        particleSize = ParticleSize.RandomSizes(20..60),
        particleColor = ParticleColor.RandomColors(listOf(primaryLight, onPrimaryLight, primaryContainerLight, tertiaryLight, tertiaryContainerLight, errorContainerLightMediumContrast)),
        lifeTime = LifeTime(355f, 2f),
        emissionType = EmissionType.FlowEmission(maxParticlesCount = 220, emissionRate = 0.8f),
        durationMillis
    )
}