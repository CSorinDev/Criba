public class Criba {
    public int[] generarPrimos(int max) {
        int i, j;

        if (max >= 2) {
            int arrayLength = max + 1;
            boolean[] esPrimo = new boolean[arrayLength];

            inicializarArray(arrayLength, esPrimo);
            eliminar01(esPrimo);
            criba(arrayLength, esPrimo);

            int cuentaPrimos = getCuentaPrimos(arrayLength, esPrimo);

            return fillPrimos(cuentaPrimos, arrayLength, esPrimo);
        } else {
            return new int[0];
        }
    }

    private static int[] fillPrimos(int cuentaPrimos, int arrayLength, boolean[] esPrimo) {
        int i;
        int j;
        int[] primos = new int[cuentaPrimos];

        for (i = 0, j = 0; i < arrayLength; i++) {
            if (esPrimo[i]) primos[j++] = i;
        }
        return primos;
    }

    private static int getCuentaPrimos(int arrayLength, boolean[] esPrimo) {
        return getCuenta(arrayLength, esPrimo);
    }

    private static void criba(int arrayLength, boolean[] esPrimo) {
        int j;
        int i;
        for (i = 2; i < Math.sqrt(arrayLength) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j = 2 * i; j < arrayLength; j += i) esPrimo[j] = false;
            }
        }
    }

    private static void eliminar01(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    private static void inicializarArray(int dim, boolean[] esPrimo) {
        int i;
        for (i = 0; i < dim; i++) esPrimo[i] = true;
    }

    private static int getCuenta(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i = 0; i < dim; i++) {
            if (esPrimo[i]) cuenta++;
        }
        return cuenta;
    }

}