package com.example.demoappmobile.components.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoappmobile.components.layouts.DefaultLayout
import com.example.demoappmobile.models.Mahasiswa

@Composable
fun MahasiswaPage(modifier: Modifier = Modifier) {
    var nrp by remember { mutableStateOf("") }
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var prodi by remember { mutableStateOf("") }
    val mahasiswaList = remember { mutableStateListOf<Mahasiswa>() }

    DefaultLayout(
        title = "Mahasiswa",
        idLabel = "NRP",
        idValue = nrp,
        onIdChange = { nrp = it },
        namaValue = nama,
        onNamaChange = { nama = it },
        alamatValue = alamat,
        onAlamatChange = { alamat = it },
        prodiValue = prodi,
        onProdiChange = { prodi = it },
        onSaveClick = {
            if (nrp.isNotEmpty() && nama.isNotEmpty() && alamat.isNotEmpty() &&
                prodi.isNotEmpty()
            ) {
                val newMahasiswa = Mahasiswa(
                    nrp = nrp,
                    nama = nama,
                    alamat = alamat,
                    prodi = prodi,
                )
                mahasiswaList.add(newMahasiswa)
                // Reset form
                nrp = ""
                nama = ""
                alamat = ""
                prodi = ""
            }
        },
        dataList = mahasiswaList,
        onDeleteClick = { id ->
            mahasiswaList.removeIf { it.id == id }
        },
        renderItem = { item ->
            val mahasiswa = item as Mahasiswa
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = mahasiswa.nama,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "NRP: ${mahasiswa.nrp}",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = "Prodi: ${mahasiswa.prodi}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Text(
                        text = "Alamat: ${mahasiswa.alamat}",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Button(
                        onClick = { mahasiswaList.removeIf { it.id == mahasiswa.id } },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFF44336)
                        )
                    ) {
                        Text("Delete")
                    }
                }
            }
        },
        modifier = modifier
    )
}

