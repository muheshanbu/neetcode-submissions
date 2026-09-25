public class TimeMap {
    class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }

    }

    HashMap<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        //if key is available, just append to list else, create new empty List for it
        //    if(!map.containsKey(key)){
        //         map.put(key,new ArrayList<>());
        //    }
        //    map.get(key).add(new TimeValue(timestamp,value));

        // the above can be shortened as
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(timestamp,value));

    }

    public String get(String key, int targetTimeStamp) {
        //Just getting all keys content
        List<TimeValue> keyVals = map.get(key);

        if(keyVals == null ){        //searched key doesnt have a val
            return "";
        }

        int left = 0;
        int right = keyVals.size() - 1;   //size of the list 1 indexed
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(keyVals.get(mid).timestamp == targetTimeStamp){
                return keyVals.get(mid).value;
            }
            else if(keyVals.get(mid).timestamp > targetTimeStamp) {
                //search inside
                right = mid - 1;
            }else{
                //target is greater, search outside mid
                left = mid + 1;
            }
        }
        if(right >= 0){
            return keyVals.get(right).value;         //right pointer stays as is, so it should be the greatest
        }else return "";
    }
}