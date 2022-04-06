package entidades;

public interface operacionesCRUD<T> {
	/**
	 * Este método inserta en la tabla correspondiente de la bdfederacion un nuevo
	 * registro
	 * 
	 * @param elemento del tipo que se quiere insertar como nuevo elemento
	 * @return true si la inserción fue exitosa, false en caso contrario
	 */
	public boolean insetarConId(T elemento);

	/**
	 * Este método inserta en la tabla correspondiente de la bdfederacion un nuevo
	 * registro
	 * 
	 * @param elemento del tipo que se quiere insertar como nuevo elemento (sin id,
	 *                 que es autocalculable)
	 * @return id del nuevo elemento insertado si tuvo éxito o -1 en caso contrario
	 */
	public long insetarSinId(T elemento);

	public T buscarPorId(long elemento);
}
