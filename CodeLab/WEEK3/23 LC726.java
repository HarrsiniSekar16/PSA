class Solution {
    public String countOfAtoms(String formula) {
        
        TreeMap<String, Integer> map = new TreeMap<>(); // Store sorted elements and counts
        Stack<Integer> counts = new Stack<>();
        
        int n = formula.length();
        StringBuilder completeFormula = new StringBuilder(); // Complete formula
        
        // Generate complete formula (adding '1')
        for (char c : formula.toCharArray())
        {
            if (completeFormula.length() > 0 && !Character.isDigit(c) && !Character.isLowerCase(c))
            {
                char end = completeFormula.charAt(completeFormula.length()-1);
                
                if (!Character.isDigit(end) && end != '(')
                    completeFormula.append("1");
            }
            
            completeFormula.append(c);
        }
        
        // Check the last character
        if (!Character.isDigit(completeFormula.charAt(completeFormula.length()-1)))
            completeFormula.append("1");
        
        int m = completeFormula.length();
        StringBuilder element = new StringBuilder();
        StringBuilder cnt = new StringBuilder();
        
        for (int i = m - 1; i >= 0; i--)
        {
            char c = completeFormula.charAt(i);
            
            if (Character.isDigit(c))
                cnt.insert(0, c);
            else if (cnt.length() > 0)
            {
                int count = Integer.parseInt(cnt.toString());
                cnt = new StringBuilder();
                
                if (counts.isEmpty())
                    counts.push(count);
                else
                    counts.push(counts.peek() * count);
            }
            
            if (Character.isLetter(c))
            {
                element.insert(0, c);
                
                if (Character.isUpperCase(c))
                {
                    map.put(element.toString(), map.getOrDefault(element.toString(), 0) + counts.pop());
                    element = new StringBuilder();
                }
            }
            else if (c == '(')
                counts.pop();
        }
        
        StringBuilder result = new StringBuilder();
        
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            String key = entry.getKey();
            int val = entry.getValue();
            
            if (val == 1)
                result.append(key);
            else
                result.append(key).append(val);
                
        }   
        
        return result.toString();
    }
}