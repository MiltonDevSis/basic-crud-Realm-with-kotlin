package com.example.realmdb

import io.realm.Realm
import io.realm.RealmResults

class RealmManager {

    val realm: Realm = Realm.getDefaultInstance()

    fun find(id: Long): Tarefa? {
        return realm.where(Tarefa::class.java).equalTo("id", id).findFirst()
    }

    fun findAll() {
        //return realm.where(Tarefa::class.java).findAll()
        val resultado: RealmResults<Tarefa> = realm.where(Tarefa::class.java).findAll()
        println(resultado)
    }

    fun insert(novaAtividade: String) {
        realm.beginTransaction()
        var newId: Long = 1
        // insert id auto
        if (realm.where(Tarefa::class.java).max("id") != null) {
            newId = realm.where(Tarefa::class.java).max("id") as Long + 1
        }
        val atividade = realm.createObject(Tarefa::class.java, newId)
        atividade.atividade = novaAtividade
        realm.commitTransaction()
    }

    fun update(id: Long, atividade: String) {
        val realm: Realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        val note = find(id)
        note?.atividade = atividade
        realm.commitTransaction()
    }

    fun deleteById(id: Long) {
        realm.beginTransaction()
        val results = realm.where(Tarefa::class.java).equalTo("id", id).findAll()
        results.deleteAllFromRealm()
        realm.commitTransaction()
    }

    fun deleteAll(){
        realm.beginTransaction()
        realm.deleteAll()
        realm.commitTransaction()
    }
}
