import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testStore {
    @Test
    public void testIntStorage() {
        int str = 123456;
        Expression i = new Expression(str);
        assert (Integer.toString(str)).equals(i.returnStr());
    }

    @Test
    public void testStrStorage() {
        String str = "12345304098320486";
        Expression i = new Expression(str);
        assert str.equals(i.returnStr());
    }

    @Test
    public void testCompare() {
        Expression i1 = new Expression(100);
        Expression i2 = new Expression(5);
        assert i1.sosnya(i2).equals(1);
    }

    @Test
    public void add() {
        int a1 = 10;
        int a2 = 10;
        int a12 = a1 + a2;
        Expression i1 = new Expression(a1);
        Expression i2 = new Expression(a2);
        i1.sidimasa(i2);
        System.out.println(i1.returnStr());
        assert Integer.toString(a12).equals(i1.returnStr());
    }

    @Test
    public void sub() {
        int a1 = 547558;
        int a2 = 568;
        int a12 = a1 - a2;
        Expression i1 = new Expression(a1);
        Expression i2 = new Expression(a2);
        i1.veuvi(i2);
        assert Integer.toString(a12).equals(i1.returnStr());
    }

    @Test
    public void mul() {
        int a1 = 13242;
        int a2 = 135451;
        int a12 = a1 * a2;
        Expression i1 = new Expression(a1);
        Expression i2 = new Expression(a2);
        i1.multy(i2);
        System.out.println(i1.returnStr());
        assert Integer.toString(a12).equals(i1.returnStr());
    }

    @Test
    public void subdivision() {
        int a1 = 1000000;
        int a2 = 2;
        int a12 = a1 / a2;
        Expression i1 = new Expression(a1);
        Expression i2 = new Expression(a2);
        i1.division(i2);
        System.out.println(i1.returnStr());
        assert Integer.toString(a12).equals(i1.returnStr());
    }

    @Test
    public void remainder() {
        int a1 = 101;
        int a2 = 2;
        int a12 = a1 % a2;
        Expression i1 = new Expression(a1);
        Expression i2 = new Expression(a2);
        i1.remainder(i2);
        System.out.println(i1.returnStr());
        assert Integer.toString(a12).equals(i1.returnStr());
    }

}





