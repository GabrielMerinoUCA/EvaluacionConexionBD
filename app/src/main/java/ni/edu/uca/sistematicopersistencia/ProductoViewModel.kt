package ni.edu.uca.sistematicopersistencia

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.dao.ProductoDao
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto

class ProductoViewModel(application: Application): AndroidViewModel(application) {
    private var daoProducto: ProductoDao
    init {
        daoProducto = BaseDatos.obtBaseDatos(application).productoDao()
    }

    fun insertarReg(entityProducto: EntityProducto) {
        viewModelScope.launch(Dispatchers.IO) {
            daoProducto.insertarReg(entityProducto)
        }
    }
}