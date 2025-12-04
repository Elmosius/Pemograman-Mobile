# Movie App - Phone & Tablet Layout

Aplikasi sederhana untuk menampilkan daftar movie dengan layout adaptif untuk Phone dan Tablet.

## Struktur File

### MainActivity

- `MainActivity.kt` - Entry point aplikasi dengan deteksi ukuran layar

### UI Components (Shared)

- `ui/component/MovieItem.kt` - Item card untuk menampilkan movie (digunakan oleh phone & tablet)
- `ui/component/MovieDetail.kt` - Komponen detail movie

### UI Phone

- `ui/phone/HomePage.kt` - Halaman utama untuk phone dengan LazyColumn
- `ui/phone/DetailPage.kt` - Halaman detail untuk phone (navigasi terpisah)

### UI Tablet

- `ui/tablet/HomePage.kt` - Halaman master-detail dalam satu layar untuk tablet

### ViewModel & Data

- `viewmodel/movie/Movie.kt` - ViewModel untuk fetch dan manage data movie
- `entity/Movie2.kt` - Data class untuk movie
- `service/ApiService.kt` - Interface Retrofit untuk API
- `service/ApiClient.kt` - Retrofit client configuration

## Cara Kerja

### Phone Layout

1. Menampilkan list movie dengan LazyColumn
2. Ketika item diklik, navigasi ke halaman detail terpisah
3. Halaman detail memiliki tombol back untuk kembali ke list

### Tablet Layout

1. Menampilkan master-detail dalam satu layar (Row layout)
2. List movie di sebelah kiri (40% lebar)
3. Detail movie di sebelah kanan (60% lebar)
4. Ketika item diklik, detail langsung muncul di sebelah kanan
5. Item yang dipilih akan ter-highlight dengan warna berbeda

## Komponen

### MovieItem (Unified Component)

- Parameter `isSelected` (optional, default = false)
- Jika `isSelected = true`, background berubah jadi primaryContainer
- Digunakan untuk phone (tanpa selection) dan tablet (dengan selection)

### MovieDetail

- Menampilkan informasi lengkap movie
- Parameter `isLoading` untuk menampilkan loading indicator
- Menampilkan: Title, ID, Poster URL, dan Description

## API Endpoints

- `GET movie_data.json` - Get all movies
- `GET m{id}.json` - Get movie detail by ID

## Dependencies

- Jetpack Compose
- Navigation Compose
- Material3 Window Size Class (untuk deteksi tablet)
- Retrofit & Kotlinx Serialization
- ViewModel & Lifecycle

