import java.util.Random;

public class LasVegasSimulation {

    public static void main(String[] args) {
        
        // Ogrenci numarasi seed olarak kullanildi
        long seed = 1220505019L;
        Random random = new Random(seed);

        // Veri hacmi n = 10^6
        int n = 1000000;
        int[] dataSet = new int[n];

        // Diziye rastgele veri atamasi (Ornek aralik: 0 - 99999)
        for (int i = 0; i < n; i++) {
            dataSet[i] = random.nextInt(100000); 
        }

        // Test parametreleri
        int totalTestRuns = 100;
        long totalStepsAllRuns = 0;
        
        // Standart sapma hesabi icin her iterasyonun suresini tutacak dizi
        double[] runTimesMs = new double[totalTestRuns];
        double totalTimeAllRuns = 0.0;

        // Teorik hesaplamalar icin K ve p degerlerinin tespiti
        int targetCount = 0;
        for (int i = 0; i < n; i++) {
            if (dataSet[i] % 7 == 0) {
                targetCount++;
            }
        }
        
        double p = (double) targetCount / n;
        double expectedSteps = 1.0 / p;

        System.out.println("Dizideki toplam hedef eleman sayisi (K): " + targetCount);
        System.out.println("Hedef secme olasiligi (p): " + p);
        System.out.println("Teorik olarak beklenen adim sayisi E[X]: " + expectedSteps);
        System.out.println("--------------------------------------------------");

        // Algoritmanin 100 kez calistirilmasi
        for (int run = 0; run < totalTestRuns; run++) {
            int currentSteps = 0;
            boolean isFound = false;
            
            long startTime = System.nanoTime();

            // Las Vegas dongusu
            while (!isFound) {
                currentSteps++;
                int randomIndex = random.nextInt(n);
                int selectedValue = dataSet[randomIndex];

                // Hedef kosul: 7'ye tam bolunebilme
                if (selectedValue % 7 == 0) {
                    isFound = true;
                    long endTime = System.nanoTime();
                    
                    double durationMs = (endTime - startTime) / 1000000.0;
                    
                    totalStepsAllRuns += currentSteps;
                    totalTimeAllRuns += durationMs;
                    runTimesMs[run] = durationMs; // Sureyi diziye kaydet
                }
            }
        }

        // Ortalama Degerlerin Hesaplanmasi
        double averageSteps = (double) totalStepsAllRuns / totalTestRuns;
        double averageTimeMs = totalTimeAllRuns / totalTestRuns;

        // Zaman Icin Standart Sapma Hesaplanmasi
        double sumSquaredDifferences = 0.0;
        for (int i = 0; i < totalTestRuns; i++) {
            sumSquaredDifferences += Math.pow(runTimesMs[i] - averageTimeMs, 2);
        }
        
        double variance = sumSquaredDifferences / totalTestRuns;
        double standardDeviation = Math.sqrt(variance);

        System.out.println("Deneysel Sonuclar (100 Iterasyon)");
        System.out.println("Ortalama Adim Sayisi     : " + averageSteps);
        System.out.println("Ortalama Sure (ms)       : " + averageTimeMs);
        System.out.println("Sure Varyansi            : " + variance);
        System.out.println("Sure Standart Sapmasi    : " + standardDeviation);
        System.out.println("--------------------------------------------------");
        System.out.println("Rapor Icin Not: Yuksek standart sapma, Las Vegas yaklasiminin calisma suresindeki rastgelelik kaynakli dalgalanmayi dogrular.");
    }
}