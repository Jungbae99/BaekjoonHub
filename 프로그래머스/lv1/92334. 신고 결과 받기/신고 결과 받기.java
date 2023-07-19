import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, HashSet<String>> reporterInfoMap = new HashMap<>();
        Map<String, Integer> reportedCountInfoMap = new HashMap<>();
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        int[] answer = new int[id_list.length];

        for (String reportInfo : reportSet) {
            String reporter = reportInfo.split(" ")[0];
            String reported = reportInfo.split(" ")[1];

            // 신고자가 없으면 set 생성
            reporterInfoMap.putIfAbsent(reporter, new HashSet<String>(){{add(reported);}});
            // 신고자가 있으면 set에 add ( set으로 한 이유? key는 신고자이며, 같은 key는 같은 신고자(value를 가질 수 없다)
            reporterInfoMap.get(reporter).add(reported);

            // 신고된 사람이 몇 번 신고되었는지 센다
            reportedCountInfoMap.put(reported, reportedCountInfoMap
                    .getOrDefault(reported, 0) + 1);
            }

        // 신고된 사람 목록에서 iter
        for (String reported : reportedCountInfoMap.keySet()) {
            int reportedCount = reportedCountInfoMap.get(reported);
            // 여기서부터 메일 발송 대상 구분 로직
            if (reportedCount >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reporterInfoMap.containsKey(id_list[i]) &&
                            reporterInfoMap.get(id_list[i]).contains(reported)) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}