import java.io.*;
import java.util.*;

public class TempReader {

    public static void main(String[] args) throws IOException {
        File pageView = new File("/home/punit/stream_logs/SEM-AL-Page-View_loghashlist.txt");
        File ads = new File("/home/punit/stream_logs/SEM-Serving-Ads_loghashlist.txt");
        File adwd = new File("/home/punit/stream_logs/SEM-Api-logs-raw_loghashlist.txt");
        HashSet<String> adwdSet = new HashSet<>(4000000);
        BufferedReader br = new BufferedReader(new FileReader(adwd));
        LinkedList<String> validLogsHashesWithFeedApiCall = new LinkedList<>();
        LinkedList<String> missingInAdwd = new LinkedList<>();
        String st;
        while ((st = br.readLine()) != null) {
            if (st.length() != 32){
                System.out.println(st);
            }
            adwdSet.add(st);
        }
        System.out.println("Total unique loghashes:"+adwdSet.size());
        br  = new BufferedReader(new FileReader(pageView));
        while ((st = br.readLine()) != null) {
            if (st.length() != 32){
                System.out.println(st);
            }
            if(adwdSet.contains(st)){
                validLogsHashesWithFeedApiCall.add(st);
            }else {
                missingInAdwd.add(st);
            }
        }
        Set<String> adwdJoinPV = new HashSet<>(validLogsHashesWithFeedApiCall);
        System.out.println("Log hashes which have made feed api call:"+validLogsHashesWithFeedApiCall.size());
        System.out.println("Missing in adwd: "+missingInAdwd.size());
        System.out.println("Unique Log hashes:"+adwdJoinPV.size());


        List<String> consistent = new LinkedList<String>();
        List<String> inconsistent = new LinkedList<String>();
        List<String> adwdNotInPV = new LinkedList<String>();
        Set<String> adsSet = new HashSet<>(4000000);
        br  = new BufferedReader(new FileReader(ads));
        while ((st = br.readLine()) != null) {
            if (st.length() != 32){
                System.out.println(st);
            }
            if(adwdJoinPV.contains(st)){
                consistent.add(st);
            }else {
                if (adwdSet.contains(st)){
                    adwdNotInPV.add(st);
                }else{
                    inconsistent.add(st);
                }
            }

            adsSet.add(st);
        }

        System.out.println("Consistent: "+consistent.size());
        System.out.println("Adwd Not In PV: "+ adwdNotInPV.size());
        System.out.println("Inconsistent: "+ inconsistent.size());

        List<String> feedApiCallForAds = new LinkedList<>();
        List<String> feedApiCallsForNonAds = new LinkedList<>();

        for (String logHash: validLogsHashesWithFeedApiCall){
            if (adsSet.contains(logHash)){
                feedApiCallForAds.add(logHash);
            }else{
                feedApiCallsForNonAds.add(logHash);
            }
        }

        System.out.println("For Ads: "+feedApiCallForAds.size());
        System.out.println("For Non Ads: "+feedApiCallsForNonAds.size());
        String prefix = "/home/punit/stream_logs/processed_loghash/";
        System.out.println("writing to file");
//        writeToFile(adwdJoinPV, new File(prefix+"adwdJoinPv.txt"));
//        writeToFile(missingInAdwd, new File(prefix+"missingInAdwd.txt"));
//        writeToFile(missingInAdwd, new File(prefix+"missingInAdwd.txt"));
//        writeToFile(consistent, new File(prefix+"consistent.txt"));
//        writeToFile(adwdNotInPV, new File(prefix+"sql_for_missing_logHash.txt"));
//        writeToFile(inconsistent, new File(prefix+"adsNotInadwd.txt"));
//        writeToFile(feedApiCallForAds, new File(prefix+"perfect_joined.txt"));
//        writeToFile(feedApiCallsForNonAds, new File(prefix+"pvNotInAds_csv.txt"));

    }

    static void writeToFile(Collection<String> data, File file) throws IOException {
        System.out.println("Writing "+file.getName());
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("(");
        for (String logHash: data) {
            writer.write("'"+logHash+"', ");
        }
        writer.close();
        System.out.println("Done Writing");
    }
}

