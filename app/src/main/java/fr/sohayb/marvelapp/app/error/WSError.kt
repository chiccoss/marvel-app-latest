package fr.sohayb.marvelapp.app.error

import fr.sohayb.marvelapp.R
import java.io.IOException
import fr.sohayb.marvelapp.base.error.Error


data class WSError(
    val code: Int,
    override val message: String
) : IOException(message) {

    fun getErrorType(): WSErrorType {
        return when (code) {
            2 -> WSErrorType.NO_INTERNET_CONNECTION

            401 -> WSErrorType.ERRORU


            409->WSErrorType.RESPONSE1
                409->WSErrorType.RESPONSE2
            409->WSErrorType.RESPONSE3
            401->WSErrorType.RESPONSE4
            401->WSErrorType.RESPONSE5
            405->WSErrorType.RESPONSE6
            403->WSErrorType.RESPONSE7


            else -> WSErrorType.UNKNOWN
        }
    }
}

enum class WSErrorType(val message: Int) : Error {
    NO_INTERNET_CONNECTION(R.string.ws_error_internet_connection),
    UNKNOWN(R.string.ws_error_unknown_error),
    ERRORU(R.string.ws_error_error),

    LIMIT_GREATER(R.string.ws_error_limit_greater),
    LIMIT_INVALID_OR_BELOW(R.string.ws_error_limit_invalid_or_below),
    INVALID_OR_RECOGNIZED_PARAM(R.string.ws_error_invalid_or_unrecognized_param),
    EMPTY_PARAM(R.string.ws_error_empty_param),
    INVALID_UNRECOGNIZED_ORDERING_PARAM(R.string.ws_error_invalid_unrecognized_ordering_param),
    TOO_MANY_VALUES(R.string.ws_error_too_many_values),
    VALUE_PASSED(R.string.ws_error_value_passed),



    RESPONSE1(R.string.reponse_409_1),
    RESPONSE2(R.string.reponse_409_2),
    RESPONSE3(R.string.reponse_409_3),
    RESPONSE4(R.string.reponse_401_1),
    RESPONSE5(R.string.reponse_401_2),
    RESPONSE6(R.string.reponse_405),
    RESPONSE7(R.string.reponse_403),

}

