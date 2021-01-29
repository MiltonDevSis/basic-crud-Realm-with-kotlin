package com.example.realmdb

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Tarefa: RealmObject() {

    @PrimaryKey
    var id: Long = 0

    var atividade: String = ""
}