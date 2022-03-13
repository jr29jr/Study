public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    public boolean saveData(String key,String value){
        Integer address=hashFunc(key);
        if(this.hashTable[address] != null){
            while(this.hashTable[address] != null){
                if(this.hashTable[address].key == key){
                    this.hashTable[address].value=value;
                    return true;
                }
                else{
                    address+=1;
                    //out of index 고려해야지
                    if(address >= this.hashTable.length)
                        return false;
                    
                }
            }
            this.hashTable[address]=new Slot(key,value);
            return true;
        }
        else{
            hashTable[address] = new Slot(key,value);
            return true;
        }
    }
    
    public String getData(String key){
        Integer address=hashFunc(key);
        if(this.hashTable[address] !=null){
            while(this.hashTable[address] != null){
                if(this.hashTable[address].key == key){
                    return this.hashTable[address].value;
                }
                else{
                    address+=1;
                    if(address>=this.hashTable.length)
                        return null;
                }
            }
            //결국 빈방에 도착하면
            return null;
        }
        else{
            return null;
        }
    }
   
}
