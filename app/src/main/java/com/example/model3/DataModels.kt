package com.example.model3

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Composable
fun colorResource(id: Int): Color {
    return androidx.compose.ui.res.colorResource(id)
}

@Composable
fun Icon(painter: Painter, tint: Color = Color.Unspecified) {
    androidx.compose.material3.Icon(
        painter = painter,
        contentDescription = null,
        tint = tint
    )
}

object UriSerializer : KSerializer<Uri> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Uri", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Uri) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): Uri {
        return Uri.parse(decoder.decodeString())
    }
}


data class MentorProfile(
    val profilePictureUri: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val career: String
)

data class MenteeProfile(
    val profilePictureUri: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val collegeName: String
)


data class MentorDetails(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val career: String = ""
)

class MentorViewModel : ViewModel() {
    private val _mentorDetails = MutableStateFlow(MentorDetails())

    val mentorDetails: StateFlow<MentorDetails> = _mentorDetails

    fun updateMentorDetails(newDetails: MentorDetails) {
        _mentorDetails.value = newDetails
    }
}

