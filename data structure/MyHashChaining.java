public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String key;
        String value;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    public boolean saveData(String key,String value){
        Integer address=hashFunc(key);
        if(hashTable[address] == null){
            hashTable[address] = new Slot(key,value);
            return true;
        }
        else{
            Slot s=hashTable[address];
            while(s.next != null){
                if(s.key == key){
                    s.value=value;
                    return true;
                }
                else{
                    s=s.next;
                }
            }
            s.next=new Slot(key,value);
            return true;
        }
    }
    
    public String getData(String key){
        Integer address=hashFunc(key);
        if(hashTable[address] == null){
            return null;
        }
        else{
            Slot nowSlot=hashTable[address];
            while(nowSlot != null){
                if(nowSlot.key==key){
                    return nowSlot.value;
                }
                else
                    nowSlot=nowSlot.next;
            }
            return null;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    
}
