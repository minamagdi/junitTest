package linstener;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {
// generate -> override method -> select methods of junit
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("this method is disabled "+context.getTestMethod()+"reason"+reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("-------------------------------------");
        System.out.println("this method is success "+context.getTestMethod());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("-------------------------------------");
        System.out.println("this method is aborted "+cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("-------------------------------------");
        System.out.println("this method is failed "+cause.getMessage());
    }
}
