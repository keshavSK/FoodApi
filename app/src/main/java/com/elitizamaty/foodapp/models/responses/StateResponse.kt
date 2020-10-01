package com.elitizamaty.foodapp.models.responses

import com.elitizamaty.foodapp.models.data_models.StateModel
import java.io.Serializable

class StateResponse : Serializable {
    var status: Int? = null
    var Message: String? = null
    var States: List<StateModel?>? = null
}