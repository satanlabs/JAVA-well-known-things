

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class ConvertAnyMapToTreeMap {
  
  /**
  THE idea is to an `N-deep map` into a `fully N-deep TreeMap`.
  Also this code should be able to handle arrays/lists
  */

    /**
     * CAUTION : WIP : THIS doesn't work for n-deep maps, onlt for
     * @param someMap
     * @return
     */
    public TreeMap<String, Object> makeMapFullyTreeMap_WIP_phase2(TreeMap<String, Object> someMap) {
        for (Map.Entry<String, Object> entry : someMap.entrySet()) {
            System.err.println(entry.getKey() + " ~ " +  entry.getValue().getClass() + " ~ " + entry.getValue());

            final String key = entry.getKey();
            final Object value = entry.getValue();
            if(Objects.nonNull(value)) {
                if(value instanceof Map) {
                    someMap.put(key, convertAnyMapToTreeMap((Map<String, Object>) value));
                }

                if(value instanceof List) {
                    List list = (List) value;

                    list.forEach(item -> {
                        System.err.println(item.getClass() + " ~ " + item);
                    });

                }
            }
        }

        return null;
    }

    private TreeMap<String, Object> convertAnyMapToTreeMap(Map<String, Object> someMap) {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.putAll(someMap);

        return treeMap;
    }
}
