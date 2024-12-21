package com.example.jeckpackcomposeinstagram

import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//@Composable
//fun SimpleReciclerView() {
//    val myList = listOf("Rei ayanami", "Misato Katsuragi", "Mari Makinami")
//    LazyColumn {
//        item {
//            Text(text = "Rei ayanami")
//        }
//        items(myList.size) {
//            Text(text = myList[it])
//
//        }
//    }
//}\
@Composable
fun SimpleReciclerView() {
    val myList = listOf("Rei ayanami", "Misato Katsuragi", "Mari Makinami")
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        content = {
            item {
                Text(text = "Rei ayanami")
            }
            items(myList.size) {
                Text(text = myList[it])

            }
        },

        )
}

//@Composable
//fun SuperPilotosEva() {
//    val context = LocalContext.current
//    LazyRow(
//        horizontalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(getPilotos().size) {
//            ItemPilotos(pilotosEva = getPilotos()[it]){
//                Toast.makeText(context,it.descripcionPiloto,Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
 @Composable
fun SuperPilotosEva() {
    val context = LocalContext.current
    val pilotos = getPilotos()
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(getPilotos().size) {
            ItemPilotos(pilotosEva = getPilotos()[it]){
                Toast.makeText(context,it.descripcionPiloto,Toast.LENGTH_SHORT).show()
            }
        }
    }
}

//@Composable
//fun SuperPilotosEva() {
//    val context = LocalContext.current
//    val rvState = rememberLazyListState()
//    val showButton = remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }
//    val corroutineScope = rememberCoroutineScope()
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        // Lista con LazyColumn
//        LazyColumn(
//            state = rvState,
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier
//                .weight(1f) // Esto asegura que LazyColumn ocupe todo el espacio disponible menos el necesario para el botón
//                .fillMaxWidth()
//        ) {
//            items(getPilotos().size) { index ->
//                ItemPilotos(pilotosEva = getPilotos()[index]) {
//                    Toast.makeText(context, it.descripcionPiloto, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//        // Botón visible cuando se ha scrolleado
//        if (showButton.value) {
//            androidx.compose.material3.Button(
//                onClick = {
//                    corroutineScope.launch {
//
//                        rvState.animateScrollToItem(0)
//                    }
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text(text = "Rei Ayanami")
//            }
//        }
//    }
//}


@Composable
fun ItemPilotos(pilotosEva: PilotosEva, onItemSelected: (PilotosEva) -> Unit = {}) {
    Card(
        border = BorderStroke(2.dp, Color.Transparent),
        modifier = Modifier
            .width(300.dp)
            .padding(8.dp)
            .clickable(onClick = { onItemSelected(pilotosEva) })

    ) {
        Column {
            Image(
                painter = painterResource(id = pilotosEva.photo),
                contentDescription = "Piloto de Eva",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .padding(top = 10.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = pilotosEva.nombrePiloto,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = pilotosEva.descripcionPiloto,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                fontSize = 9.sp,
                maxLines = 3
            )
            Text(
                text = pilotosEva.unidaPilotada,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 6.dp, end = 9.dp)

            )
        }
    }
}


fun getPilotos(): List<PilotosEva> {
    return listOf(
        PilotosEva(
            nombrePiloto = "Rei ayanami",
            descripcionPiloto = "Rei Ayanami, una joven misteriosa y reservada, es la Primera Niña y piloto del EVA Unidad 00. Es conocida por su calma emocional y su dedicación al cumplimiento de sus misiones.",
            unidaPilotada = "Unidad 00 ",
            photo = R.drawable.reiayanami

        ),
        PilotosEva(
            nombrePiloto = "Asuka Langley Soryu",
            descripcionPiloto = "La Segunda Niña y piloto del EVA Unidad 02, es una chica apasionada, orgullosa y extremadamente competitiva, que lucha por demostrar su valía como piloto.",
            unidaPilotada = "Unidad 02",
            photo = R.drawable.azukala
        ),
        PilotosEva(
            nombrePiloto = "Mari Makinami",
            descripcionPiloto = "Mari Makinami Illustrious, la enigmática piloto del EVA Unidad 08, es conocida por su actitud relajada y su amor por el combate, mostrando una personalidad única y energética.",
            unidaPilotada = "Unidad 08",
            photo = R.drawable.marimakinami
        )

    )
}