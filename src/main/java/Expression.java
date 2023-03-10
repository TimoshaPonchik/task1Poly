import java.util.*;

public class Expression {
    private final List<String> numList;

    public Expression(String input) {
        if (!input.matches("[1-9][0-9]*") && input.matches(".0$")) {
            throw new IllegalArgumentException("Некорректный ввод");
        }
        String[] number = input.split("");
        numList = new LinkedList<>();
        numList.addAll(Arrays.asList(number));
    }

    public Expression(int val) {
        this(Integer.toString(val));
    }

    public String returnStr() {
        StringBuilder StringBuilder = new StringBuilder();
        for (String s : numList) {
            StringBuilder.append(s);
        }
        return StringBuilder.toString();
    }

    public Integer compare(Expression other) {
        for (int i = 0; i < numList.size(); i++) {
            if (Integer.parseInt(numList.get(i)) < Integer.parseInt(other.numList.get(i)) || numList.size() < other.numList.size()) {
                return -1;
            }

            if (Integer.parseInt(numList.get(i)) > Integer.parseInt(other.numList.get(i)) || numList.size() > other.numList.size()) {
                return 1;
            }
        }
        return 0;
    }

    public void add(Expression other) {
        int overflowAdd = 0;
        int firstTerm;
        int secondTerm;
        int sumTerm;
        align(numList, other.numList);
        for (int i = numList.size() - 1; i > -1; i--) {
            firstTerm = Integer.parseInt(numList.get(i));
            secondTerm = Integer.parseInt(other.numList.get(i));
            if (firstTerm + secondTerm + overflowAdd > 9) {
                sumTerm = firstTerm + secondTerm + overflowAdd - 10;
                overflowAdd = 1;
            } else {
                sumTerm = firstTerm + secondTerm + overflowAdd;
                overflowAdd = 0;
            }
            numList.set(i, Integer.toString(sumTerm));
        }
        if (overflowAdd == 1) {
            numList.add(0, "1");
        }
    }

    public void veuvi(Expression other) {
        int overflowSub = 0;
        int firstTerm;
        int secondTerm;
        int subTerm;
        align(numList, other.numList);
        for (int i = numList.size() - 1; i > -1; i--) {
            firstTerm = Integer.parseInt(numList.get(i));
            secondTerm = Integer.parseInt(other.numList.get(i));
            if (firstTerm - secondTerm < 1) {
                for (int ii = i - 1; ii > -1; ii--) {
                    if (numList.get(ii).equals("0")) {
                        numList.set(ii, "9");
                    } else {
                        numList.set(ii, Integer.toString(Integer.parseInt(numList.get(ii)) - 1));
                        overflowSub = 10;
                        break;
                    }
                }
                subTerm = firstTerm - secondTerm + overflowSub;
            } else {
                subTerm = firstTerm - secondTerm;
            }
            overflowSub = 0;
            numList.set(i, Integer.toString(subTerm));
        }
        zeroCheck(numList);
    }

    public void multy(Expression other) {
        int mulTerm;
        int overflow = 0;
        int shift = 0;
        int tempRes;
        Expression i1 = new Expression("0");
        align(numList, other.numList);
        for (int i = numList.size() - 1; i > -1; i--) {
            StringBuilder coder = new StringBuilder();
            LinkedList<Object> secondTerm = new LinkedList<>();
            for (int ii = numList.size() - 1; ii > -1; ii--) {
                tempRes = (Integer.parseInt(numList.get(i)) * Integer.parseInt(other.numList.get(ii)) + overflow);
                mulTerm = tempRes % 10;
                secondTerm.add(0, (mulTerm));
                overflow = (tempRes + overflow - mulTerm) / 10;
            }
            if (overflow != 0) {
                secondTerm.add(0, overflow);
                overflow = 0;
            }
            shift++;
            for (int iii = 1; iii < shift; iii++) {
                secondTerm.add(secondTerm.size(), "0");
            }
            for (Object charNum : secondTerm) {
                coder.append(charNum);
            }
            Expression i2 = new Expression(String.valueOf(coder));
            i1.add(i2);
        }
        numList.clear();
        numList.addAll(Arrays.asList(i1.returnStr().split("")));
        zeroCheck(numList);
    }

    /*
    public void division(Expression other) {
        int mulTerm;
        int overflow = 0;
        int shift = 0;
        int tempRes;
        align(numList, other.numList);
        for (int i = 0; i < numList.size(); i++) {
            for (int ii = 0; ii < numList.size(); ii++) {
                if ((Integer.parseInt(numList.get(i)) % Integer.parseInt(other.numList.get(ii)) != 0)) {

                }
            }
        }
    }
*/
    private void align(List<String> a, List<String> b) {
        while (a.size() != b.size()) {
            if (a.size() >= b.size()) {
                b.add(0, "0");
            } else {
                a.add(0, "0");
            }
        }
    }

    private void zeroCheck(List<String> a) {
        while (a.get(0).equals("0")) {
            a.remove(0);
        }
    }
}





/*
- dataFields:
    -> целое число >= 0
- methods
    -> сравнить на равенство: больше/меньше, сложить, вычесть, умножить, разделить, найти остаток от деления
    (конструктор из строки, целого числа. Не использовать BigInteger и т.п.)
 */


/////////////////////////////////////