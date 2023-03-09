package com.benjamin.apiRes.Commons.impl

import com.benjamin.apiRes.Commons.api.GenericServiceAPI
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
/**
 * Implementación de la interfaz [GenericServiceAPI]
 * @see GenericServiceAPI
 */
abstract class GenericServiceImpl<T : Any, ID : Serializable> : GenericServiceAPI<T, ID> {
    /**
     * Inserta un registro en la tabla
     * @param entity: entidad a insertar
     * @return [entity] entidad insertada
     */
    override fun insertar(entity: T): T {
        return dao.save(entity)
    }

    /**
     * Elimina un registro de la tabla
     * @param id: id de la entidad a eliminar
     */
    override fun eliminar(id: ID) {
        dao.deleteById(id)
    }

    /**
     * Obtiene un registro de la tabla
     * @param id: id de la entidad a obtener
     * @return [obj]: entidad obtenida
     */
    override operator fun get(id: ID): T? {
        return dao.findByIdOrNull(id)
    }

    /**
     * Obtiene todos los registros de la tabla
     * @return [returnList]: lista de entidades obtenidas
     */
    override val all: MutableList<T>?
        get() {
            val returnList = mutableListOf<T>()
            dao.findAll().forEach { returnList.add(it) }
            return returnList
        }


    /**
     * Dao de la entidad
     * @return [dao]: dao de la entidad
     * @see CrudRepository
     */
    abstract val dao: CrudRepository<T, ID>
}