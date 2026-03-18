package TP_3.EX1;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class FibonacciServiceImpl extends UnicastRemoteObject implements FibonacciService {
    protected FibonacciServiceImpl() throws RemoteException {
        super();
    }
    @Override
    public int fibonacci(int n) throws RemoteException {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
