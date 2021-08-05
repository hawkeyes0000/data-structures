/*
    Implement hashing using open addressing (linear)
*/

import java.util.*;

class OpenAddressing
{
    int[] arr;
    int capacity;
    int size;
    OpenAddressing(int cap)
    {
        this.capacity = cap;
        arr = new int[cap];
        Arrays.fill(arr, -1);
        size = 0;
    }
    
    int hash(int element)
    {
        return element % capacity;
    }
    
    boolean search(int element)
    {
        if(size == 0)
        {
            return false;
        }
        int hash = hash(element);
        int h = hash;
        while(arr[h] != element && arr[h] != -1)
        {
            h = hash(h+1);
            if(h == hash)
            {
                break;
            }
        }
        if(arr[h] == element)
        {
            return true;
        }
        return false;
    }
    
    boolean insert(int element)
    {
        if(size == capacity) { return false; } 
        int hash = hash(element);
        int h = hash;
        while(arr[h] != -1 && arr[h] != -2)
        {
            h = hash(h + 1);
        }
        arr[h] = element;
        ++size;
        return true;
    }
    
    boolean delete(int element)
    {
        if(size == 0)
        {
            return false;
        }
        int hash = hash(element);
        int h = hash;
        while(arr[h] != element)
        {
            h = hash(h + 1);
            if(h == hash)
            {
                return false;
            }
        }
        arr[h] = -2;
        --size;
        return true;
    }
    
    void print()
    {
        for(int i = 0; i < capacity; i++)
        {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    OpenAddressing oa = new OpenAddressing(7);	
	    oa.insert(16);
	    oa.insert(7);
	    oa.insert(23);
	    oa.insert(8);
	    oa.insert(1);
	    oa.insert(6);
	    oa.insert(5);
	    oa.print();
	    oa.delete(23);
	    oa.delete(1);
	    oa.insert(4);
	    oa.insert(400000);
	    oa.insert(74);
	    oa.delete(400000);
	    oa.delete(7);
	    oa.delete(8);
	    oa.insert(1);
	    oa.print();
	}
}
