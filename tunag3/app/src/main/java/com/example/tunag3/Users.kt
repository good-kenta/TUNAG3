package com.example.tunag3

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class Users : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    @Required
    var name: String = ""
    var mail: String = ""
    var telephone: String = ""
    var password: String = ""


}