package com.benjamin.apiRes.Commons.api

import java.io.Serializable

interface GenericServiceAPI<T, ID: Serializable> {
    /**
     * Inserta un registro en la tabla
     */
    fun insertar(entity: T): T

    /**
     * Elimina un registro de la tabla
     */
    fun eliminar(id: ID)

    /**
     * Obtiene un registro de la tabla
     */
    operator fun get(id: ID): T?

    /**
     * Obtiene todos los registros de la tabla
     */
    val all: MutableList<T>?
}