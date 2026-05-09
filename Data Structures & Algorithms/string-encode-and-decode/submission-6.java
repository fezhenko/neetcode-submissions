class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isBlank() || str == null) {
            return List.of();
        }
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int sharpIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, sharpIndex));
            String separated = str.substring(sharpIndex + 1, sharpIndex + 1 + length);
            strs.add(separated);
            i = sharpIndex + 1 + length;
        }
        return strs;
    }
}
