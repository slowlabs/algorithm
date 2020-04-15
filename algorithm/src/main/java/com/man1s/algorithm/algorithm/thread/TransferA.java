package com.man1s.algorithm.algorithm.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TransferA {


    public static void main(String[] args) {
        try {
            new Client().syncInvoke();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

}



/**
 * 转账服务的实现
 */
class TransferService {

    private  AccountService accountService = new AccountService(); // 使用依赖注入获取账户服务的实例
    public CompletableFuture<Void> transfer(int fromAccount, int toAccount, int amount) {
        // 异步调用add方法从fromAccount扣减相应金额
        return accountService.add(fromAccount, -1 * amount)
                // 然后调用add方法给toAccount增加相应金额
                .thenCompose(v -> accountService.add(toAccount, amount));
    }
}


class Client {
    private TransferService transferService = new TransferService(); // 使用依赖注入获取转账服务的实例
    private final static int A = 1000;
    private final static int B = 1001;

    public void syncInvoke() throws ExecutionException, InterruptedException {
        // 同步调用
        transferService.transfer(A, B, 100).get();
        System.out.println("转账完成！");
    }

    public void asyncInvoke() {
        // 异步调用
        transferService.transfer(A, B, 100)
                .thenRun(() -> System.out.println("转账完成！"));
    }
}



/**
 * 转账服务的实现
 */
class AccountService {

    public CompletableFuture<Void> add(int from ,int to){
        return new CompletableFuture<>();
    }

}
