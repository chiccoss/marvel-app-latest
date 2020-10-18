package fr.sohayb.marvelapp.app.api

import okhttp3.internal.and
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class AuthHashGenerator {
    fun generateHash(
        timestamp: Long,
        publicKey: String,
        privateKey: String
    ): String {
        return try {
            val value = "$timestamp$privateKey$publicKey"
            val md5Encoder: MessageDigest = MessageDigest.getInstance("MD5")
            val md5Bytes: ByteArray = md5Encoder.digest(value.toByteArray())
            val md5 = StringBuilder()
            for (i in md5Bytes.indices) {
                md5.append(
                    Integer.toHexString(md5Bytes[i] and 0xFF or 0x100)
                        .substring(1, 3)
                )
            }
            md5.toString()
        } catch (e: NoSuchAlgorithmException) {
            System.out.print(e.message.toString()).toString()
        }
    }
}




//