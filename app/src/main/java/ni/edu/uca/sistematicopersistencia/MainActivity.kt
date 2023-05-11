package ni.edu.uca.sistematicopersistencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productoViewModel: ProductoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        productoViewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)
        inciar()
        setContentView(binding.root)
    }

    private fun inciar() {
        binding.btnCrear.setOnClickListener {
            val entityProducto = EntityProducto(
                0,
                binding.etNombre.text.toString().trim(),
                binding.etPrecio.text.toString().trim().toDouble(),
                binding.etExistencia.text.toString().trim().toInt()
            )
            productoViewModel.insertarReg(entityProducto)
            Toast.makeText(this, "Creado exitosamente", Toast.LENGTH_SHORT).show()
        }

    }
}
