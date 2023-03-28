package com.kt.kot.demo.commons

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.io.Serializable
import java.util.function.Consumer
@Service
abstract class GenericServiceImp<T : Any, ID: Serializable?> : GenericServiceAPI<T, ID>{

    abstract val dao: CrudRepository<T, ID>

    override fun save(entity: T): T {
        return dao.save(entity)
    }

    override fun delete(id: ID) {
        if (id != null){
            dao.deleteById(id)
        }
    }

    override fun get(id: ID): T? {
        return if (id != null){
            val obj = dao.findById(id)
            return if (obj.isPresent){
                obj.get()
            } else null
        } else null
    }

    override val all: MutableList<T>?
        get() {
            val returList: MutableList<T> = ArrayList()
            dao.findAll().forEach { obj: T -> returList.add(obj) }
            return returList
        }


}