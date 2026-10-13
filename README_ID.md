# Project Wildan AI — versi lengkap (starter)

## Yang tersedia
- Ikon robot mengambang di atas aplikasi lain; bisa digeser dan diketuk.
- Panel chat dengan pengiriman pesan ke backend melalui HTTPS.
- Pengenalan ucapan bahasa Indonesia dengan Android SpeechRecognizer.
- Pembacaan jawaban menggunakan Android TextToSpeech.
- URL backend dapat diatur dari layar utama.

## Catatan tentang AI online
Kode Android ini adalah klien untuk backend, bukan layanan AI itu sendiri. Agar jawaban benar-benar dihasilkan AI, deploy backend HTTPS dan implementasikan pemanggilan penyedia model AI di `backend/server.js`. Backend harus menerima `{"message":"..."}` dan mengembalikan `{"reply":"..."}`. Jangan masukkan API key ke APK atau repo publik.

## Build APK
1. Instal Android Studio dan JDK 17.
2. Ekstrak ZIP, lalu Android Studio → Open → pilih folder `project_wildan_full`.
3. Tunggu Gradle Sync. Instal Android SDK 35 jika diminta.
4. Pilih Build → Build Bundle(s) / APK(s) → Build APK(s).
5. APK debug biasanya berada di `app/build/outputs/apk/debug/app-debug.apk`.
6. Instal di HP Android (API 26 / Android 8.0 atau lebih baru).
7. Buka Project Wildan, masukkan URL backend HTTPS yang sudah dideploy, lalu tekan Simpan.
8. Tekan Aktifkan / Tampilkan Robot, dan izinkan “Tampilkan di atas aplikasi lain”.
9. Ketuk ikon robot untuk chat. Tombol mikrofon mengenali ucapan dan langsung mengirimnya ke backend; jawaban AI dibacakan otomatis jika TTS tersedia.

## Kontrak backend
POST `/chat` dengan body JSON `{"message":"pertanyaan"}` dan balas HTTP 200 JSON `{"reply":"jawaban AI"}`.
Contoh starter backend ada di `backend/server.js`; masih mengembalikan HTTP 501 sampai kamu mengintegrasikan model AI pilihanmu.

## Batasan dan keamanan
- Proyek ini belum menghasilkan APK binary; build perlu dilakukan di Android Studio.
- AI sungguhan memerlukan backend dan akses layanan model AI yang sesuai.
- Produksi sebaiknya memakai autentikasi pengguna, rate limiting, batas biaya, validasi input, dan HTTPS.
- Pengenalan suara Android dapat memakai layanan pengenalan suara yang disediakan perangkat.
- Beberapa perangkat/ROM dapat membatasi overlay atau service ketika aplikasi berjalan di latar belakang.
