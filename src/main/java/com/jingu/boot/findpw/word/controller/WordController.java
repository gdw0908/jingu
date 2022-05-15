package com.jingu.boot.findpw.word.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jingu.boot.findpw.word.service.WordService;

@Controller
@RestController
public class WordController {
	
	Logger log = LoggerFactory.getLogger(WordController.class);
	
	@Autowired
	WordService wordService;
	
	
	@RequestMapping(value = "/jingu/findPw")
	public ModelAndView findPw(@RequestParam HashMap<String,Object> reqMap,  HttpServletRequest req, HttpSession session) {
		log.debug("jingu findPw page");
		log.debug("세션 ID : "+session.getId());
		ModelAndView mav = new ModelAndView();
		
		//List<HashMap<String, Object>> resultList =adminService.selectAdminList(reqMap);
		/*
		 * PageUtil pagination = new PageUtil(resultList.size(),
		 * Integer.parseInt(StringUtil.nvl((String)reqMap.get("page"),"1")) );
		 * 
		 * reqMap.put("page",
		 * (Integer.parseInt(StringUtil.nvl((String)reqMap.get("page"),"1"))-1)*10);
		 * reqMap.put("row", pagination.getPageSize()); resultList
		 * =adminService.selectAdminList(reqMap);
		 * 
		 * mav.addObject("list", resultList); mav.addObject("param", reqMap);
		 * mav.addObject("pagination", pagination);
		 */		
		mav.addObject("sessionId", session.getId());
		mav.setViewName("/jingu/findPw");
		return mav;
	}
	@RequestMapping(value = "/jingu/findCalcPw")
	public void findCalcPw(@RequestParam HashMap<String,Object> reqMap,  HttpServletRequest req, HttpSession session) {
		log.debug("jingu findCalcPw page");
		log.debug("세션 ID : "+reqMap.get("sessionId"));
		ModelAndView mav = new ModelAndView();
		
		//wordService.insert_word(reqMap);
		
		//Map<String, Object> wordInfo =wordService.select_word_list(reqMap);
		
        /*int n = 12;
        String[] arr = {(String)reqMap.get("word1"), (String)reqMap.get("word2"), (String)reqMap.get("word3"), (String)reqMap.get("word4"),
        		(String)reqMap.get("word5"),(String)reqMap.get("word6"),(String)reqMap.get("word7"),
        		(String)reqMap.get("word8"),(String)reqMap.get("word9"),(String)reqMap.get("word10"),
        		(String)reqMap.get("word11"),(String)reqMap.get("word12")};
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
        	//if(i == 12) {
            System.out.println("\n" + n + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, n, i);
        	//}
        }*/

        ArrayList<Integer> inputList = new ArrayList<Integer>();
        inputList.add(Integer.parseInt((String)reqMap.get("word1")));
        inputList.add(Integer.parseInt((String)reqMap.get("word2")));
        inputList.add(Integer.parseInt((String)reqMap.get("word3")));
        /*inputList.add(Integer.parseInt((String)reqMap.get("word4")));
        inputList.add(Integer.parseInt((String)reqMap.get("word5")));
        inputList.add(Integer.parseInt((String)reqMap.get("word6")));
        inputList.add(Integer.parseInt((String)reqMap.get("word7")));
        inputList.add(Integer.parseInt((String)reqMap.get("word8")));
        inputList.add(Integer.parseInt((String)reqMap.get("word9")));
        inputList.add(Integer.parseInt((String)reqMap.get("word10")));
        inputList.add(Integer.parseInt((String)reqMap.get("word11")));
        inputList.add(Integer.parseInt((String)reqMap.get("word12")));*/

        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
		getPermutationCore(resultList, inputList);
		log.debug("여기까지 왓니???"+resultList.toString()+" 결과 갯수 : "+resultList.size());
		
        ArrayList<String> inputList2 = new ArrayList<String>();
        inputList2.add((String)reqMap.get("word1"));
        inputList2.add((String)reqMap.get("word2"));
        inputList2.add((String)reqMap.get("word3"));
        ArrayList<ArrayList<String>> resultList2 = new ArrayList<ArrayList<String>>();
		getPermutationCore2(resultList2, inputList2);
		log.debug("여기까지 왓니???"+resultList2.toString()+" 결과 갯수 : "+resultList2.size());
		
		
		
		mav.setViewName("/jingu/findPw");
		//return mav;
	}
	
	// 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(String[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    
    private void getPermutationCore(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> inputList) {
        
        // 인덱스리스트 구하기
        ArrayList<ArrayList<Integer>> suffledIndexList = getSuffledIndexList(inputList.size());
        if (suffledIndexList == null || suffledIndexList.size() == 0) {
            return;
        }
       
        int count = suffledIndexList.size();
        for (int i=0; i<count; i++) {
            ArrayList<Integer> oneResult = new ArrayList<Integer>();
           
            ArrayList<Integer> indexList = suffledIndexList.get(i);
            for (int j=0; j<indexList.size(); j++) {
                oneResult.add(inputList.get(indexList.get(j)));
            }
           
            resultList.add(oneResult);
        }
    }
    
    private ArrayList<ArrayList<Integer>> getSuffledIndexList(int count) {
        ArrayList<ArrayList<Integer>> suffledIndexList = new ArrayList<ArrayList<Integer>>();
        shuffleRecursively(suffledIndexList, null, count, null);
        return suffledIndexList;
    }
    
    private void shuffleRecursively(ArrayList<ArrayList<Integer>> resultList, ArrayList<Integer> inputResult, int totalCount, ArrayList<Integer> exceptList) {
        if (exceptList == null) {
            exceptList = new ArrayList<Integer>();
        }
       
        for (int i=0; i<totalCount; i++) {
            if (exceptList.contains(i)) {
                continue;
            }
           
            ArrayList<Integer> oneResult = null;
            if (exceptList.size() == 0) {
                oneResult = new ArrayList<Integer>();
            } else {
                oneResult = (ArrayList<Integer>) inputResult.clone();
            }
           
            if (oneResult.size() < totalCount) {
                oneResult.add(i);
               
                if (oneResult.size() == totalCount) {
                    resultList.add(oneResult);
                   
                } else if (oneResult.size() < totalCount) {
                    ArrayList<Integer> newExceptList = (ArrayList<Integer>) exceptList.clone();
                    newExceptList.add(i);
                   
                    shuffleRecursively(resultList, oneResult, totalCount, newExceptList);
                }
            }
        }
    }

    	private void getPermutationCore2(ArrayList<ArrayList<String>> resultList, ArrayList<String> inputList) {
        
        // 인덱스리스트 구하기
        //ArrayList<ArrayList<String>> suffledIndexList = getSuffledIndexList(inputList.size());
        ArrayList<ArrayList<String>> suffledIndexList = getSuffledIndexList(inputList);
        if (suffledIndexList == null || suffledIndexList.size() == 0) {
            return;
        }
       
        int count = suffledIndexList.size();
        for (int i=0; i<count; i++) {
            ArrayList<String> oneResult = new ArrayList<String>();
           
            ArrayList<String> indexList = suffledIndexList.get(i);
            for (int j=0; j<indexList.size(); j++) {
            		for (int k=0; k<inputList.size(); k++) {
            			if(inputList.get(j).equals(indexList.get(k))){
                			oneResult.add(inputList.get(j));
                			break;
                		}	
            		}
            }
           
            resultList.add(oneResult);
        }
    }
    
    private ArrayList<ArrayList<String>> getSuffledIndexList(ArrayList<String> inputList) {
        ArrayList<ArrayList<String>> suffledIndexList = new ArrayList<ArrayList<String>>();
        shuffleRecursively(suffledIndexList, null, inputList, null);
        return suffledIndexList;
    }
    
    private void shuffleRecursively(ArrayList<ArrayList<String>> resultList, ArrayList<String> inputResult, ArrayList<String> inputList, ArrayList<String> exceptList) {
        if (exceptList == null) {
            exceptList = new ArrayList<String>();
        }
       
        for (int i=0; i<inputList.size(); i++) {
            if (exceptList.contains(i)) {
                continue;
            }
           
            ArrayList<String> oneResult = null;
            if (exceptList.size() == 0) {
                oneResult = new ArrayList<String>();
            } else {
                oneResult = (ArrayList<String>) inputResult.clone();
            }
           
            if (oneResult.size() < inputList.size()) {
                oneResult.add(inputList.get(i));
               
                if (oneResult.size() == inputList.size()) {
                    resultList.add(oneResult);
                   
                } else if (oneResult.size() < inputList.size()) {
                    ArrayList<String> newExceptList = (ArrayList<String>) exceptList.clone();
                    newExceptList.add(inputList.get(i));
                   
                    shuffleRecursively(resultList, oneResult, inputList, newExceptList);
                }
            }
        }
    }
    
    
	
}
