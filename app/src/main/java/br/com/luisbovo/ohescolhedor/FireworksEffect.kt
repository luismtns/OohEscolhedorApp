package br.com.luisbovo.ohescolhedor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.luisbovo.ohescolhedor.ui.theme.Purple40
import br.com.luisbovo.ohescolhedor.ui.theme.Purple80
import br.com.luisbovo.ohescolhedor.ui.theme.PurpleGrey40
import br.com.luisbovo.ohescolhedor.ui.theme.PurpleGrey80
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
    modifier:Modifier = Modifier
) {
    CreateParticles(
        modifier = modifier,
        x = 500f, y = 0f,
        velocity = Velocity(xDirection = 2f, yDirection = -2f, randomize = true),
        force = Force.Gravity(0.3f),
        acceleration = Acceleration(),
        particleSize = ParticleSize.RandomSizes(20..60),
        particleColor = ParticleColor.RandomColors(listOf(Purple40, Purple80, PurpleGrey40, PurpleGrey80, Color.Blue, Color.White, Color.Magenta, Color.Green)),
        lifeTime = LifeTime(255f, 2f),
        emissionType = EmissionType.FlowEmission(maxParticlesCount = EmissionType.FlowEmission.INDEFINITE, emissionRate = 0.8f),
        durationMillis = 10 * 1000
    )
}