package com.br.pokemonfinder.data.remote.model

import com.google.gson.annotations.SerializedName

class ConfigPayload {
    lateinit var content: Content

    lateinit var version: Version

    class Content {
        @SerializedName("cover")
        lateinit var coverUrl: String
    }

    class Version {
        @SerializedName("required_app_version")
        lateinit var required: String

        @SerializedName("update_text")
        lateinit var updateText: String
    }
}