package com.example.j922springproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@SpringBootApplication
@EnableAsync
@EnableFeignClients
public class J922SpringProjectApplication {

    public static void main(String[] args) throws IOException {

        //SpringApplication.run(J922SpringProjectApplication.class, args);
        System.out.println(getMinTime(4, 5, List.of(0, 0, 1, 1), List.of(2, 5, 5, 1)));
    }

    public static int getMinTime(int n, int d, List<Integer> x, List<Integer> y) {
        int result = 1;
        Double[] myArray = new Double[n];
        for (int i = 0; i < n; i++) {
            myArray[i] = (Math.sqrt(x.get(i) * x.get(i) + y.get(i) * y.get(i)));
        }

        Arrays.sort(myArray);

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(myArray[i] - myArray[i + 1]) > d) {
                result++;
            }
        }

        return result;
    }

    public static List<Integer> getMaxUpgradedServers(List<Integer> num_servers,
                                                      List<Integer> money,
                                                      List<Integer> sell,
                                                      List<Integer> upgrade) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num_servers.size(); i++) {
            Integer ns = num_servers.get(i);
            Integer m = money.get(i);
            Integer u = upgrade.get(i);
            Integer s = sell.get(i);
            Integer result = 0;

            if (ns * u <= m) {
                list.add(ns);
            } else {
                Integer d = m / u;
                result += d;
                ns -= d;
                m -= u * d;

                do {
                    if (m < u) {
                        m += s;
                    } else {
                        result++;
                        m -= u;
                    }
                    ns--;
                } while (ns != 0);
                list.add(result);
            }
        }

        return list;
    }


    public static List<Long> countMinimumOperations(List<Integer> price, List<Integer> query) {
        List<Long> result = new ArrayList<>();

        for (Integer q : query) {
            Long sum = 0L;
            for (Integer p : price) {
                sum += Math.abs(q - p);
            }
            result.add(sum);
        }

        return result;
    }


    //        System.out.println(findCompletePrefixes(List.of("Kanan", "Kanan test", "Test"),
//                List.of("Kan", "123", "Tes")));

    //System.out.println(preprocessDate(List.of("16tr May 1960")));

    //System.out.println(findMinWeight(List.of(30, 20, 25), 3));

//        System.out.println(getMinTime(1, 2, 3,
//                        List.of("www.google.com", "test",
//                                "testov", "test", "test",
//                                "www.yahoo.com", "testov", "test"
//                        )
//                )
//        );


    public static List<Integer> getMinTime(int cache_size,
                                           int cache_time,
                                           int server_time,
                                           List<String> urls) {

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, String> urlMap = new HashMap<>();

        for (int i = 0; i < urls.size(); i++) {
            if (urlMap.containsValue(urls.get(i))) {
                Integer key = 0;
                for (Map.Entry<Integer, String> entry : urlMap.entrySet()) {
                    if (urls.get(i).equals(entry.getValue())) {
                        key = entry.getKey();
                        break;
                    }
                }
                urlMap.remove(key);

                result.add(cache_time);
            } else {
                result.add(server_time);
            }

            System.out.println(urlMap.size());
            if (urlMap.size() > cache_size) {
                urlMap.remove(urlMap.keySet().toArray()[0]);
            }

            urlMap.put(i, urls.get(i));
        }

        return result;
    }


    public static int findMinWeight(List<Integer> weights, int d) {
        int result = 0;
        ArrayList<Integer> remainingWeights = new ArrayList<>(weights);

        int j = 0;
        for (int i = 0; i < d; i++, j++) {
            if (remainingWeights.get(j) <= 0) remainingWeights.remove(j);

            if (j == remainingWeights.size()) {
                j = 0;
            }
            remainingWeights.set(j, remainingWeights.get(j) - remainingWeights.get(j) / 2);
        }

        for (Integer w : remainingWeights) {
            result += w;
        }

        return result;
    }


    public static List<String> preprocessDate(List<String> dates) {
        List<String> resultDates = new ArrayList<>();

        for (int i = 0; i < dates.size(); i++) {
            String[] arr = dates.get(i).split(" ");

            String month = "";
            switch (arr[1]) {
                case "Jan":
                    month = "01";
                    break;
                case "Feb":
                    month = "02";
                    break;
                case "Mar":
                    month = "03";
                    break;
                case "Apr":
                    month = "04";
                    break;
                case "May":
                    month = "05";
                    break;
                case "Jun":
                    month = "06";
                    break;
                case "Jul":
                    month = "07";
                    break;
                case "Aug":
                    month = "08";
                    break;
                case "Sep":
                    month = "09";
                    break;
                case "Oct":
                    month = "10";
                    break;
                case "Nov":
                    month = "11";
                    break;
                case "Dec":
                    month = "12";
                    break;
            }

            String day = arr[0].substring(0, dates.get(i).length() - 11);
            if (day.length() == 1) day = "0" + day;

            String date = arr[2] + "-" + month + "-" + day;
            resultDates.add(date);
        }

        return resultDates;
    }

    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query) {
        Integer[] arr = new Integer[query.size()];
        Arrays.fill(arr, 0);

        for (int i = 0; i < query.size(); i++) {
            for (String name : names) {
                if (name.startsWith(query.get(i)) && !name.equals(query.get(i))) {
                    arr[i]++;
                    break;
                }
            }
        }

        return Arrays.asList(arr);
    }


}
