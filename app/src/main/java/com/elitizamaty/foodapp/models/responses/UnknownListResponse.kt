package com.elitizamaty.foodapp.models.responses

import com.elitizamaty.foodapp.models.data_models.UnknownModel
import java.io.Serializable

class UnknownListResponse : Serializable {
    var page: Int? = null
    var per_page: Int? = null
    var total: Int? = null
    var total_pages: Int? = null
    var data: List<UnknownModel?>? = null
}