public class prime_number {
    public static void main(String[] args) {
        System.out.println(" prime numbers : ");
        int count = 0;
        int number = 2;

        while (count < 50) {
            boolean isPrime = true;
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
                System.out.print(number + "\t");


                if (count % 10 == 0) {
                    System.out.println();
                }
            }

            number++;
        }


    }
    }

