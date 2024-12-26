import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ATMT_TRANSACTIONTest {

    private BankAccount2 bankAccount;
    private SavingsAccount2 savingsAccount;
    private CurrentAccount currentAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount2();
        savingsAccount = new SavingsAccount2();
        currentAccount = new CurrentAccount();
    }

    @Test
    public void depositeTest() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        double initialBalance = bankAccount.checkBalance();
        bankAccount.deposite();
        assertEquals(initialBalance + 1000, bankAccount.checkBalance(), 0.001);
    }

    @Test
    public void withdrawTest() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        double initialBalance = bankAccount.checkBalance();
        bankAccount.withdraw();
        assertEquals(initialBalance - 1000, bankAccount.checkBalance(), 0.001);
    }

    @Test
    public void checkBalanceTest() {
        assertEquals(20000, bankAccount.checkBalance(), 0.001);
    }

    @Test
    public void getAmountTest() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        bankAccount.deposite();
        assertEquals(1000, bankAccount.getAmount(), 0.001);
    }

    @Test
    public void savingsAccountWithdrawTest() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        double initialBalance = savingsAccount.checkBalance();
        savingsAccount.withdraw();
        assertEquals(initialBalance - 1000, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void savingsAccountInsufficientBalanceTest() {
        savingsAccount = new SavingsAccount2() {
            @Override
            double checkBalance() {
                return 500;
            }
        };

        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        savingsAccount.withdraw();
        assertEquals(500, savingsAccount.checkBalance(), 0.001);
    }

    @Test
    public void currentAccountWithdrawTest() {
        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        double initialBalance = currentAccount.checkBalance();
        currentAccount.withdraw();
        assertEquals(initialBalance - 1000, currentAccount.checkBalance(), 0.001);
    }

    @Test
    public void currentAccountInsufficientBalanceTest() {
        currentAccount = new CurrentAccount() {
            @Override
            double checkBalance() {
                return 500;
            }
        };

        String input = "1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        currentAccount.withdraw();
        assertEquals(500, currentAccount.checkBalance(), 0.001);
    }
}
