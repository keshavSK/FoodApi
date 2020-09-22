package com.elitizamaty.foodapp.models.data_models

import java.io.Serializable

class UserModel : Serializable {
    var id: Int? = null
    var email: String? = null
    var first_name: String? = null
    var last_name: String? = null
    var avatar: String? = null
}