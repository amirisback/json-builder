package app.model

/**
 * Created by Faisal Amir on 29/10/22
 * -----------------------------------------
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) Frogobox ID / amirisback
 * All rights reserved
 */

data class BaseModel<T>(
    var status: Int? = 200,
    var message: String? = "Success",
    val data: T
) {
    constructor(data: T) : this(200, "Success", data)
}
