package TP_3.EX1;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface FibonacciService extends Remote {
    int fibonacci(int n) throws RemoteException;
}