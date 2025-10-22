package com.example.demoappmobile.components.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoappmobile.components.ui.DropdownField
import com.example.demoappmobile.components.ui.InputField

@Composable
fun DefaultLayout(
    title: String,
    idLabel: String,
    idValue: String,
    onIdChange: (String) -> Unit,
    namaValue: String,
    onNamaChange: (String) -> Unit,
    alamatValue: String,
    onAlamatChange: (String) -> Unit,
    prodiValue: String,
    onProdiChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    dataList: List<Any>,
    onDeleteClick: (String) -> Unit,
    renderItem: @Composable (Any) -> Unit,
    modifier: Modifier = Modifier
) {
    val prodiOptions = listOf(
        "Teknik Informatika",
        "Sistem Informasi",
        "Teknik Elektro",
        "Teknik Industri",
        "Teknik Mesin"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Form Section
        Text(
            text = "Form $title",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        InputField(
            label = idLabel,
            value = idValue,
            onValueChange = onIdChange
        )

        InputField(
            label = "Nama",
            value = namaValue,
            onValueChange = onNamaChange
        )

        InputField(
            label = "Alamat",
            value = alamatValue,
            onValueChange = onAlamatChange,
            maxLines = 3
        )

        DropdownField(
            label = "Program Studi",
            value = prodiValue,
            onValueChange = onProdiChange,
            options = prodiOptions
        )

        Button(
            onClick = onSaveClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE)
            )
        ) {
            Text("Simpan", fontSize = 16.sp, modifier = Modifier.padding(8.dp))
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 2.dp
        )

        // Data List Section
        Text(
            text = "Daftar $title",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (dataList.isEmpty()) {
            Text(
                text = "Belum ada data",
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        } else {
            dataList.forEach { item ->
                renderItem(item)
            }
        }
    }
}