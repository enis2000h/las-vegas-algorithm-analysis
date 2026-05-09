# Las Vegas Algorithm Simulation

Bu proje, algoritma analizi kapsamında **Las Vegas rastgelelik yaklaşımının** performansını ve zaman karmaşıklığını test etmek amacıyla geliştirilmiştir. 

## 📌 Proje Özeti
Sistem, çalışma anında bellekte **1.000.000 (10^6) elemanlı rastgele bir veri seti** oluşturur. Las Vegas algoritması kullanılarak, bu devasa veri seti içerisinde belirli bir koşulu (örneğin 7'ye tam bölünme) sağlayan eleman aranır. Algoritma, aranan elemanı bulana kadar rastgele seçim yapmaya devam eder (%100 doğruluk oranı).

## ⚙️ Teknik Özellikler
* **Rastgelelik Beslemesi (Seed):** Geliştiricinin öğrenci numarası (1220505019) kullanılarak deterministik rastgelelik sağlanmıştır.
* **Zaman Analizi:** Algoritma arka arkaya **100 kez** çalıştırılarak ortalama işlem süresi, varyans ve standart sapma hesaplanmıştır.
* **Teorik Karşılaştırma:** Beklenen adım sayısı (E[X]) teorik olarak hesaplanmış ve sistemin ürettiği deneysel ortalama ile başarıyla karşılaştırılmıştır.

## 🚀 Kurulum ve Çalıştırma
1. Bu repoyu yerel bilgisayarınıza klonlayın.
2. `LasVegasSimulation.java` dosyasını tercih ettiğiniz bir Java ortamında (VS Code, Eclipse, IntelliJ) açın.
3. Kodu çalıştırın. Tüm teorik olasılık hesaplamaları ve 100 iterasyonluk deneysel analiz sonuçları doğrudan konsol ekranına yazdırılacaktır.
