
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
//import java.util.Map;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.*;

//import LoopDE.Loop_PathDE.MyCallable;

import java.util.Set;
;

//import com.google.common.collect.HashMultimap;
//import com.google.common.collect.Multimap;

/*Author Semujju Stuart Dereck*/
public class Ktgde{

	private static final int RUN = 30; // the number of the program runs. For simple test purpose i set it to one
	private static final double F = 0.5;
	private static final int bias = 10;
	private static final int pop_num = 50; // the number of test cases
	/// private static final int fun_num = 1; // the serial number of the target
	/// benchmark function.
	private static final int R = 10;
	private static final int NODENUM = 2; // the number of the nodes/vertex in the target benchmark function.
	// static boolean[][] visit = new boolean[NODENUM][4]; // '2' is for 'Yes'
	// branch and 'No' branch.
	// private static final int MCN = 300000; // the maximum test case number for a
	// template.
	// private static final int MainCN = 1000000000; // test cases to be used in a
	// int bias = 10;
	private static final int col = 0;

	private static final int col_3 = 3;

	private static final int col_2 = 2;

	static int[] average_coverage_count = new int[RUN];

	private static final double Pc = 0.2;
	// private static final double non_simpleid = 99.0; // identifier given to test
	// case not traversing a path pattern in
	// the group
	// private static final double non_simpleid2 = 100.0;// identifier given to test
	// case traversing a path pattern in the
	// group

	// private static final double non_simpleid = 99.0; // identifier given to test
	// case not traversing a path in the group
	// private static final double non_simpleid2 = 100.0;// identifier given to test
	// case traversing a path in the group
	private static final int PATHNUM = 32; // In this test bench mark there are 16 groups each with 32 paths
	// private static int case_sum = 0;
	private static int objective_size;
	public static int MAXIMUM_REACHED = 0;

	private static int[][] temp_1 = new int[PATHNUM][R];
	private static int[][] temp_2 = new int[PATHNUM][R];
	private static int[][] temp_3 = new int[PATHNUM][R];
	private static int[][] temp_4 = new int[PATHNUM][R];
	private static int[][] temp_5 = new int[PATHNUM][R];
	private static int[][] temp_6 = new int[PATHNUM][R];
	private static int[][] temp_7 = new int[PATHNUM][R];
	private static int[][] temp_8 = new int[PATHNUM][R];
	private static int[][] temp_9 = new int[PATHNUM][R];
	private static int[][] temp_10 = new int[PATHNUM][R];
	private static int[][] temp_11 = new int[PATHNUM][R];
	private static int[][] temp_12 = new int[PATHNUM][R];
	private static int[][] temp_13 = new int[PATHNUM][R];
	private static int[][] temp_14 = new int[PATHNUM][R];
	private static int[][] temp_15 = new int[PATHNUM][R];
	private static int[][] temp_16 = new int[PATHNUM][R];
	private static int[][] temp_17 = new int[PATHNUM][R];
	private static int[][] temp_18 = new int[PATHNUM][R];
	private static int[][] temp_19 = new int[PATHNUM][R];
	private static int[][] temp_20 = new int[PATHNUM][R];
	private static int[][] temp_21 = new int[PATHNUM][R];
	private static int[][] temp_22 = new int[PATHNUM][R];
	private static int[][] temp_23 = new int[PATHNUM][R];
	private static int[][] temp_24 = new int[PATHNUM][R];
	private static int[][] temp_25 = new int[PATHNUM][R];
	private static int[][] temp_26 = new int[PATHNUM][R];
	private static int[][] temp_27 = new int[PATHNUM][R];
	private static int[][] temp_28 = new int[PATHNUM][R];
	private static int[][] temp_29 = new int[PATHNUM][R];
	private static int[][] temp_30 = new int[PATHNUM][R];
	private static int[][] temp_31 = new int[PATHNUM][R];
	private static int[][] temp_32 = new int[PATHNUM][R];

	private static int[][] temp_holder = new int[50][R];
	// private static int fitsizex = 0;
	private static final int TOTAL_PATHNUM = 1024;

	static int pattern_number = 5;
	// static int[] path_id = new int[PATHNUM];
	// static boolean[] status = new boolean[8];

	// static double[][] fitness_matrix = new double[NODENUM][5];
	// static int pattern_number = 3; // The simple loop pattern number of this
	// benchmark is set to the first four 4
	// iterations()

	static LinkedHashMap<String, Boolean> temporary_path_holder = new LinkedHashMap<String, Boolean>();
	static LinkedHashMap<String, Integer> pathcounter = new LinkedHashMap<String, Integer>();
	static LinkedHashMap<String, List<Double>> combined_maps = new LinkedHashMap<String, List<Double>>();
	static LinkedHashMap<String, Boolean> evaluated_status = new LinkedHashMap<String, Boolean>();
	public static Map<String, int[][]> dynamic_access = new HashMap<String, int[][]>();

	// These are the identifiers(I.Ds) for each group/template based on the simple
	// loop path pattern
	static String template_1 = "aaaaa";
	static String template_2 = "aaaab";
	static String template_3 = "aaaba";
	static String template_4 = "aaabb";
	static String template_5 = "aabaa";
	static String template_6 = "aabab";
	static String template_7 = "aabba";
	static String template_8 = "aabbb";
	static String template_9 = "abaaa";

	static String template_10 = "abaab";
	static String template_11 = "ababa";
	static String template_12 = "ababb";
	static String template_13 = "abbaa";
	static String template_14 = "abbab";
	static String template_15 = "abbba";
	static String template_16 = "abbbb";
	static String template_17 = "baaaa";
	static String template_18 = "baaab";

	static String template_19 = "baaba";
	static String template_20 = "baabb";
	static String template_21 = "babaa";
	static String template_22 = "babab";
	static String template_23 = "babba";
	static String template_24 = "babbb";
	static String template_25 = "bbaaa";
	static String template_26 = "bbaab";
	static String template_27 = "bbaba";

	static String template_28 = "bbabb";
	static String template_29 = "bbbaa";
	static String template_30 = "bbbab";
	static String template_31 = "bbbba";
	static String template_32 = "bbbbb";

	public static int totalpathcounter;
	// ****************************************************************************************************************************************************************//

	// static int[][] dynamic16;

	// static int que = 1;
	// static double start; // the beginning time of the program run(not used in
	// this code)
	// static double finish; // the finish time of the program run(not used in this
	// code)
	static int[] Cycle = new int[RUN];
	static float[] coverage = new float[RUN];
	static double[] runtime = new double[RUN];
	static int[] case_num = new int[RUN];
	static int[] total_case_num = new int[RUN];
	// static int[] itr = new int[4];

	public static int timeTaskCount = 0;
	static int[][] convergencegraph = new int[16][RUN];
	static String[] Bug_data = new String[RUN];
	
	static boolean bug_one = false; 
	
	static String bug_one_;

	static String[] dynamo = { template_1, template_2, template_3, template_4, template_5, template_6, template_7,
			template_8, template_9, template_10, template_11, template_12, template_13, template_14, template_15,
			template_16, template_17, template_18, template_19, template_20, template_21, template_22, template_23,
			template_24, template_25, template_26, template_27, template_28, template_29, template_30, template_31,
			template_32 }; // this will be used later, currently not implemented

	static String[] groupss_0 = { template_2, template_3, template_4, template_5, template_6, template_7, template_8,
			template_9, template_10, template_11, template_12, template_13, template_14, template_15, template_16 }; // aaaaa
																														// //template_1

	static String[] groupss_1 = { template_17, template_18, template_19, template_20, template_21, template_22,
			template_23, template_24, template_25, template_26, template_27, template_28, template_29, template_30,
			template_31 }; // bbbbb template_32

	// Here we create files(groups) to hold/store the number of similar paths in
	// each separate group

	static String location = "C:/Users/Stuart/Final/LPCF/Bench/"; //set location for finding bug report
	
	
	static File bug_report = new File(location + "Diamond1bugreport.txt");
	
	static int bugrecord = 0;
	static String buggypath;
	static int input;
	static int bugcount1 = 0;
	static File allpaths = new File(location + "All.txt");

	static File id_1 = new File(location + "aaaaa.txt");
	static File id_2 = new File(location + "aaaab.txt");
	static File id_3 = new File(location + "aaaba.txt");
	static File id_4 = new File(location + "aaabb.txt");
	static File id_5 = new File(location + "aabaa.txt");
	static File id_6 = new File(location + "aabab.txt");
	static File id_7 = new File(location + "aabba.txt");
	static File id_8 = new File(location + "aabbb.txt");
	static File id_9 = new File(location + "abaaa.txt");
	static File id_10 = new File(location + "abaab.txt");
	static File id_11 = new File(location + "ababa.txt");
	static File id_12 = new File(location + "ababb.txt");
	static File id_13 = new File(location + "abbaa.txt");
	static File id_14 = new File(location + "abbab.txt");
	static File id_15 = new File(location + "abbba.txt");
	static File id_16 = new File(location + "abbbb.txt");
	static File id_17 = new File(location + "baaaa.txt");
	static File id_18 = new File(location + "baaab.txt");
	static File id_19 = new File(location + "baaba.txt");
	static File id_20 = new File(location + "baabb.txt");
	static File id_21 = new File(location + "babaa.txt");
	static File id_22 = new File(location + "babab.txt");
	static File id_23 = new File(location + "babba.txt");
	static File id_24 = new File(location + "babbb.txt");
	static File id_25 = new File(location + "bbaaa.txt");
	static File id_26 = new File(location + "bbaab.txt");
	static File id_27 = new File(location + "bbaba.txt");
	static File id_28 = new File(location + "bbabb.txt");
	static File id_29 = new File(location + "bbbaa.txt");
	static File id_30 = new File(location + "bbbab.txt");
	static File id_31 = new File(location + "bbbba.txt");
	static File id_32 = new File(location + "bbbbb.txt");

	public static int[][] solution_1 = new int[PATHNUM][R];
	public static int[][] solution_2 = new int[PATHNUM][R];
	public static int[][] solution_3 = new int[PATHNUM][R];
	public static int[][] solution_4 = new int[PATHNUM][R];
	public static int[][] solution_5 = new int[PATHNUM][R];
	public static int[][] solution_6 = new int[PATHNUM][R];
	public static int[][] solution_7 = new int[PATHNUM][R];
	public static int[][] solution_8 = new int[PATHNUM][R];
	public static int[][] solution_9 = new int[PATHNUM][R];
	public static int[][] solution_10 = new int[PATHNUM][R];
	public static int[][] solution_11 = new int[PATHNUM][R];
	public static int[][] solution_12 = new int[PATHNUM][R];
	public static int[][] solution_13 = new int[PATHNUM][R];
	public static int[][] solution_14 = new int[PATHNUM][R];
	public static int[][] solution_15 = new int[PATHNUM][R];
	public static int[][] solution_16 = new int[PATHNUM][R];
	public static int[][] solution_17 = new int[PATHNUM][R];
	public static int[][] solution_18 = new int[PATHNUM][R];
	public static int[][] solution_19 = new int[PATHNUM][R];
	public static int[][] solution_20 = new int[PATHNUM][R];
	public static int[][] solution_21 = new int[PATHNUM][R];
	public static int[][] solution_22 = new int[PATHNUM][R];
	public static int[][] solution_23 = new int[PATHNUM][R];
	public static int[][] solution_24 = new int[PATHNUM][R];
	public static int[][] solution_25 = new int[PATHNUM][R];
	public static int[][] solution_26 = new int[PATHNUM][R];
	public static int[][] solution_27 = new int[PATHNUM][R];
	public static int[][] solution_28 = new int[PATHNUM][R];
	public static int[][] solution_29 = new int[PATHNUM][R];
	public static int[][] solution_30 = new int[PATHNUM][R];
	public static int[][] solution_31 = new int[PATHNUM][R];
	public static int[][] solution_32 = new int[PATHNUM][R];

	public static boolean[] statu_1 = new boolean[PATHNUM];
	public static boolean[] statu_2 = new boolean[PATHNUM];
	public static boolean[] statu_3 = new boolean[PATHNUM];
	public static boolean[] statu_4 = new boolean[PATHNUM];
	public static boolean[] statu_5 = new boolean[PATHNUM];
	public static boolean[] statu_6 = new boolean[PATHNUM];
	public static boolean[] statu_7 = new boolean[PATHNUM];
	public static boolean[] statu_8 = new boolean[PATHNUM];
	public static boolean[] statu_9 = new boolean[PATHNUM];
	public static boolean[] statu_10 = new boolean[PATHNUM];
	public static boolean[] statu_11 = new boolean[PATHNUM];
	public static boolean[] statu_12 = new boolean[PATHNUM];
	public static boolean[] statu_13 = new boolean[PATHNUM];
	public static boolean[] statu_14 = new boolean[PATHNUM];
	public static boolean[] statu_15 = new boolean[PATHNUM];
	public static boolean[] statu_16 = new boolean[PATHNUM];
	public static boolean[] statu_17 = new boolean[PATHNUM];
	public static boolean[] statu_18 = new boolean[PATHNUM];
	public static boolean[] statu_19 = new boolean[PATHNUM];
	public static boolean[] statu_20 = new boolean[PATHNUM];
	public static boolean[] statu_21 = new boolean[PATHNUM];
	public static boolean[] statu_22 = new boolean[PATHNUM];
	public static boolean[] statu_23 = new boolean[PATHNUM];
	public static boolean[] statu_24 = new boolean[PATHNUM];
	public static boolean[] statu_25 = new boolean[PATHNUM];
	public static boolean[] statu_26 = new boolean[PATHNUM];
	public static boolean[] statu_27 = new boolean[PATHNUM];
	public static boolean[] statu_28 = new boolean[PATHNUM];
	public static boolean[] statu_29 = new boolean[PATHNUM];
	public static boolean[] statu_30 = new boolean[PATHNUM];
	public static boolean[] statu_31 = new boolean[PATHNUM];
	public static boolean[] statu_32 = new boolean[PATHNUM];

	public static int obj_1;
	public static int obj_2;
	public static int obj_3;
	public static int obj_4;
	public static int obj_5;
	public static int obj_6;
	public static int obj_7;
	public static int obj_8;
	public static int obj_9;
	public static int obj_10;
	public static int obj_11;
	public static int obj_12;
	public static int obj_13;
	public static int obj_14;
	public static int obj_15;
	public static int obj_16;

	public static int obj_17;
	public static int obj_18;
	public static int obj_19;
	public static int obj_20;
	public static int obj_21;
	public static int obj_22;
	public static int obj_23;
	public static int obj_24;
	public static int obj_25;
	public static int obj_26;
	public static int obj_27;
	public static int obj_28;
	public static int obj_29;
	public static int obj_30;
	public static int obj_31;
	public static int obj_32;

	public static int point;
	public static int[][] x = new int[pop_num][R];
	public static int[][] v = new int[pop_num][R];

	static int run = 0;

	// static LinkedHashMap<String, Integer> itr1 = new LinkedHashMap<String,
	// Integer>();

	static LinkedHashMap<String, Boolean> paths = new LinkedHashMap<String, Boolean>();

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {

		int k = 10;

		char[] set = { 'a', 'b' };
		char[] str = new char[k];

		enumeratePaths(k, set, str, 0); // call function to generate the paths
		init_Template();// function to create the groups of paths. // using the simple loop path pattern
						// information

		LinkedHashMap<String, List<String>> group_map = new LinkedHashMap<String, List<String>>();

		List<String> neighbor_0 = new ArrayList<String>();
		List<String> neighbor_1 = new ArrayList<String>();

		for (int gr = 0; gr < groupss_0.length; gr++) {

			neighbor_0.add(groupss_0[gr]);

		} // populate neighbors starting with 0

		for (int gr_1 = 0; gr_1 < groupss_1.length; gr_1++) {

			neighbor_1.add(groupss_1[gr_1]);

		} // populate neighbors starting with 1

		List<String> group_0_list = new ArrayList<String>(); // aaa //template_1
		List<String> group_1_list = new ArrayList<String>(); // bbb template_22

		group_0_list.addAll(neighbor_0);

		group_map.put(template_1, group_0_list);

		group_1_list.addAll(neighbor_1);

		group_map.put(template_32, group_1_list);

		int[] lb = new int[R];// lower bound
		int[] ub = new int[R];// upper bound

		for (int i = 0; i < 1; i++)

		{
			lb[i] = Integer.MIN_VALUE;// lower bound
			ub[i] = Integer.MAX_VALUE;// upper bound
		}
		//run = 0;
		while (run < RUN) {

			// int group_counter = 0;
			bug_one = false; 
			point = -1;

			x = new int[pop_num][R];
			v = new int[pop_num][R];

			LinkedHashMap<String, List<Double>> fitnessmaps = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps1 = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps2 = new LinkedHashMap<String, List<Double>>();
			LinkedHashMap<String, List<Double>> fitnessmaps3 = new LinkedHashMap<String, List<Double>>();

			LinkedHashMap<String, Integer> setrank1 = new LinkedHashMap<String, Integer>();
			LinkedHashMap<String, Integer> setrank2 = new LinkedHashMap<String, Integer>();

			LinkedHashMap<String, Integer> setrank3 = new LinkedHashMap<String, Integer>();

			List<String> updated_population = new ArrayList<String>();

			List<String> offspring_population = new ArrayList<String>();
			List<String> offspring_population2 = new ArrayList<String>();

			List<String> single_population = new ArrayList<String>();

			String traverse_template;

			// the 2d arrays below hold the solutions to each respective group

			solution_1 = new int[PATHNUM][R];
			solution_2 = new int[PATHNUM][R];
			solution_3 = new int[PATHNUM][R];
			solution_4 = new int[PATHNUM][R];
			solution_5 = new int[PATHNUM][R];
			solution_6 = new int[PATHNUM][R];
			solution_7 = new int[PATHNUM][R];
			solution_8 = new int[PATHNUM][R];
			solution_9 = new int[PATHNUM][R];
			solution_10 = new int[PATHNUM][R];
			solution_11 = new int[PATHNUM][R];
			solution_12 = new int[PATHNUM][R];
			solution_13 = new int[PATHNUM][R];
			solution_14 = new int[PATHNUM][R];
			solution_15 = new int[PATHNUM][R];
			solution_16 = new int[PATHNUM][R];
			solution_17 = new int[PATHNUM][R];
			solution_18 = new int[PATHNUM][R];
			solution_19 = new int[PATHNUM][R];
			solution_20 = new int[PATHNUM][R];
			solution_21 = new int[PATHNUM][R];
			solution_22 = new int[PATHNUM][R];
			solution_23 = new int[PATHNUM][R];
			solution_24 = new int[PATHNUM][R];
			solution_25 = new int[PATHNUM][R];
			solution_26 = new int[PATHNUM][R];
			solution_27 = new int[PATHNUM][R];
			solution_28 = new int[PATHNUM][R];
			solution_29 = new int[PATHNUM][R];
			solution_30 = new int[PATHNUM][R];
			solution_31 = new int[PATHNUM][R];
			solution_32 = new int[PATHNUM][R];

			statu_1 = new boolean[PATHNUM];
			statu_2 = new boolean[PATHNUM];
			statu_3 = new boolean[PATHNUM];
			statu_4 = new boolean[PATHNUM];
			statu_5 = new boolean[PATHNUM];
			statu_6 = new boolean[PATHNUM];
			statu_7 = new boolean[PATHNUM];
			statu_8 = new boolean[PATHNUM];
			statu_9 = new boolean[PATHNUM];
			statu_10 = new boolean[PATHNUM];
			statu_11 = new boolean[PATHNUM];
			statu_12 = new boolean[PATHNUM];
			statu_13 = new boolean[PATHNUM];
			statu_14 = new boolean[PATHNUM];
			statu_15 = new boolean[PATHNUM];
			statu_16 = new boolean[PATHNUM];
			statu_17 = new boolean[PATHNUM];
			statu_18 = new boolean[PATHNUM];
			statu_19 = new boolean[PATHNUM];
			statu_20 = new boolean[PATHNUM];
			statu_21 = new boolean[PATHNUM];
			statu_22 = new boolean[PATHNUM];
			statu_23 = new boolean[PATHNUM];
			statu_24 = new boolean[PATHNUM];
			statu_25 = new boolean[PATHNUM];
			statu_26 = new boolean[PATHNUM];
			statu_27 = new boolean[PATHNUM];
			statu_28 = new boolean[PATHNUM];
			statu_29 = new boolean[PATHNUM];
			statu_30 = new boolean[PATHNUM];
			statu_31 = new boolean[PATHNUM];
			statu_32 = new boolean[PATHNUM];

			obj_1 = 0;
			obj_2 = 0;
			obj_3 = 0;
			obj_4 = 0;
			obj_5 = 0;
			obj_6 = 0;
			obj_7 = 0;
			obj_8 = 0;
			obj_9 = 0;
			obj_10 = 0;
			obj_11 = 0;
			obj_12 = 0;
			obj_13 = 0;
			obj_14 = 0;
			obj_15 = 0;
			obj_16 = 0;
			obj_17 = 0;
			obj_18 = 0;
			obj_19 = 0;
			obj_20 = 0;
			obj_21 = 0;
			obj_22 = 0;
			obj_23 = 0;
			obj_24 = 0;
			obj_25 = 0;
			obj_26 = 0;
			obj_27 = 0;
			obj_28 = 0;
			obj_29 = 0;
			obj_30 = 0;
			obj_31 = 0;
			obj_32 = 0;

			temp_1 = new int[PATHNUM][R];
			temp_2 = new int[PATHNUM][R];
			temp_3 = new int[PATHNUM][R];
			temp_4 = new int[PATHNUM][R];
			temp_5 = new int[PATHNUM][R];
			temp_6 = new int[PATHNUM][R];
			temp_7 = new int[PATHNUM][R];
			temp_8 = new int[PATHNUM][R];
			temp_9 = new int[PATHNUM][R];
			temp_10 = new int[PATHNUM][R];
			temp_11 = new int[PATHNUM][R];
			temp_12 = new int[PATHNUM][R];
			temp_13 = new int[PATHNUM][R];
			temp_14 = new int[PATHNUM][R];
			temp_15 = new int[PATHNUM][R];
			temp_16 = new int[PATHNUM][R];
			temp_17 = new int[PATHNUM][R];
			temp_18 = new int[PATHNUM][R];
			temp_19 = new int[PATHNUM][R];
			temp_20 = new int[PATHNUM][R];
			temp_21 = new int[PATHNUM][R];
			temp_22 = new int[PATHNUM][R];
			temp_23 = new int[PATHNUM][R];
			temp_24 = new int[PATHNUM][R];
			temp_25 = new int[PATHNUM][R];
			temp_26 = new int[PATHNUM][R];
			temp_27 = new int[PATHNUM][R];
			temp_28 = new int[PATHNUM][R];
			temp_29 = new int[PATHNUM][R];
			temp_30 = new int[PATHNUM][R];
			temp_31 = new int[PATHNUM][R];
			temp_32 = new int[PATHNUM][R];

			totalpathcounter = 0;

			// int obj_total = 0;

			timeTaskCount = 0;

			//Timer timer = new Timer();

			//TimerTask task = new TimerTask() {};

			//timer.schedule(task, 10000, 20000);

			String getfinalpath;
			String final_path_checker;

			if (run > 0) { // in each run reset the number counter of the paths covered in each group

				reset_All();
				updated_population.clear();
				offspring_population.clear();
				offspring_population2.clear();
				single_population.clear();
				combined_maps.clear();
				setrank1.clear();
				setrank2.clear();
				setrank3.clear();
				bug_one = false; 
				// fitnessmaps.clear();
				// fitnessmaps1.clear();
				// fitnessmaps2.clear();
				// fitnessmaps3.clear();

			}

			for (int i = 0; i < pop_num; i++) // initialize the population with the dimension of R values/inputs
			{

				for (int j = 0; j < R; j++) {

					x[i][j] = (int) (Math.random() * ((ub[j] - lb[j]) + 1)) + lb[j];
					// x[i][j] =(int)(lb[j] + Math.random() * (ub[j] - lb[j]));
				}

				// case_num[run] = case_num[run] + 1 ; // test case number

				/// total_case_num[run] = total_case_num[run] + 1; // here we start to count the
				/// test case

				getfinalpath = pathnum(x[i]); // path traversed by input x is returned

				// //(" hereeeee " + getfinalpath);

				traverse(getfinalpath, i);

			}

			long start_big_time = System.currentTimeMillis();
			long wait_main_time = 300000;
			long end_main_time = start_big_time + wait_main_time;

			// case_num[run] = 0; // reset test case number assigned to each template

			// iterator
			// case_sum = 0;
			// iterator

			// Cycle[run] = 1;

			// long start_big_time = System.currentTimeMillis();
			// long wait_main_time = 600000;
			// long end_main_time = start_big_time + wait_main_time;
			for (int iterator = 0; iterator < 32; iterator++) { // iterator of all templates // checks to perform // is
				// maximum id the group number. Here I take only one group for test purposes
				// only // it already evaluated
				temporary_path_holder.clear();
				dynamic_access.clear();
				// int infeasible_path = 0;

				// selection of the group is based on the group with least number of remaining
				// paths among all the other groups
				// (in comparison of all the other paths)
				int value;
				String minKey = " ";
				// String tempss_1 = " ";
				int minValue = 0;

				int count = 0;

				Iterator<Map.Entry<String, Boolean>> iter = evaluated_status.entrySet().iterator();

				while (iter.hasNext()) {

					Map.Entry<String, Boolean> entry = iter.next();

					if (entry.getValue() == true) {

						iter.remove();

					}

				}

				for (String key : evaluated_status.keySet()) {
					count++;

					if (count == 1) {

						minKey = key;
						minValue = (pathcounter.get(key));

						break;
					}
				}

				int counters = 0;

				for (String key6 : evaluated_status.keySet()) {

					counters++;

					if (counters == 1) {

						continue;
					}

					else {

						// tempss_1 = key6;
						value = pathcounter.get(key6);

						if (value > minValue) {

							minValue = value;
							minKey = key6;
						}
					}

				}

				traverse_template = minKey;

				evaluated_status.put(traverse_template, true);

				try {
					File fstream_temporary = new File(location + traverse_template + ".txt");
					FileReader fileReader_ = new FileReader(fstream_temporary);
					BufferedReader br_ = new BufferedReader(fileReader_);
					String strLine_temporary;

					while ((strLine_temporary = br_.readLine()) != null) {

						// read files into map

						if (!paths.get(strLine_temporary)) {

							temporary_path_holder.put(strLine_temporary, false);
						}
					}
					br_.close();
				}

				catch (Exception e) {
				}

				if (iterator > 0) {

					for (int a = 0; a < PATHNUM; a++) {

						if (statu_1[a]) {

							for (int j = 0; j < R; j++) {

								temp_1[a][j] = solution_1[a][j];

							}

						}
						
						else {
							
							for (int j = 0; j < R; j++) {

								temp_1[a][j] = 500;

							}
							
							
							
						}

					}
					// group_map.put(template_32, group_1_list);
					dynamic_access.put(template_1, temp_1);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_2[a]) {

							for (int j = 0; j < R; j++) {
								temp_2[a][j] = solution_2[a][j];

							}

						}
						
                        else {
							
							for (int j = 0; j < R; j++) {

								temp_2[a][j] = 500;

							}
							
							
							
						}
						

					}

					dynamic_access.put(template_2, temp_2);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_3[a]) {

							for (int j = 0; j < R; j++) {
								temp_3[a][j] = solution_3[a][j];

							}

						}
						
                       else {
							
							for (int j = 0; j < R; j++) {

								temp_3[a][j] = 500;

							}
							
							
							
						}

					}

					dynamic_access.put(template_3, temp_3);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_4[a]) {

							for (int j = 0; j < R; j++) {
								temp_4[a][j] = solution_4[a][j];

							}

						}
						
               

					}

					dynamic_access.put(template_4, temp_4);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_5[a]) {

							for (int j = 0; j < R; j++) {
								temp_5[a][j] = solution_5[a][j];

							}

						}
                     

					}

					dynamic_access.put(template_5, temp_5);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_6[a]) {

							for (int j = 0; j < R; j++) {
								temp_6[a][j] = solution_6[a][j];

							}

						}
                    

					}

					dynamic_access.put(template_6, temp_6);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_7[a]) {

							for (int j = 0; j < R; j++) {
								temp_7[a][j] = solution_7[a][j];

							}

						}
						

					}

					dynamic_access.put(template_7, temp_7);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_8[a]) {

							for (int j = 0; j < R; j++) {
								temp_8[a][j] = solution_8[a][j];

							}

						}
					}

					dynamic_access.put(template_8, temp_8);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_9[a]) {

							for (int j = 0; j < R; j++) {
								temp_9[a][j] = solution_9[a][j];

							}

						}
					}

					dynamic_access.put(template_9, temp_9);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_10[a]) {

							for (int j = 0; j < R; j++) {
								temp_10[a][j] = solution_10[a][j];

							}

						}

					}

					dynamic_access.put(template_10, temp_10);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_11[a]) {

							for (int j = 0; j < R; j++) {
								temp_11[a][j] = solution_11[a][j];

							}

						}

					}

					dynamic_access.put(template_11, temp_11);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_12[a]) {

							for (int j = 0; j < R; j++) {
								temp_12[a][j] = solution_12[a][j];

							}

						}

					}

					dynamic_access.put(template_12, temp_12);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_13[a]) {

							for (int j = 0; j < R; j++) {
								temp_13[a][j] = solution_13[a][j];

							}

						}
					}

					dynamic_access.put(template_13, temp_13);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_14[a]) {

							for (int j = 0; j < R; j++) {
								temp_14[a][j] = solution_14[a][j];

							}

						}

					}

					dynamic_access.put(template_14, temp_14);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_15[a]) {

							for (int j = 0; j < R; j++) {
								temp_15[a][j] = solution_15[a][j];

							}

						}

					}

					dynamic_access.put(template_15, temp_15);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_16[a]) {

							for (int j = 0; j < R; j++) {
								temp_16[a][j] = solution_16[a][j];

							}

						}

					}

					dynamic_access.put(template_16, temp_16);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_17[a]) {

							for (int j = 0; j < R; j++) {
								temp_17[a][j] = solution_17[a][j];

							}

						}

					}

					dynamic_access.put(template_17, temp_17);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_18[a]) {

							for (int j = 0; j < R; j++) {
								temp_18[a][j] = solution_18[a][j];

							}

						}

					}

					dynamic_access.put(template_18, temp_18);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_19[a]) {

							for (int j = 0; j < R; j++) {
								temp_19[a][j] = solution_19[a][j];

							}

						}
					}

					dynamic_access.put(template_19, temp_19);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_20[a]) {

							for (int j = 0; j < R; j++) {
								temp_20[a][j] = solution_20[a][j];

							}

						}
					}

					dynamic_access.put(template_20, temp_20);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_21[a]) {

							for (int j = 0; j < R; j++) {
								temp_21[a][j] = solution_21[a][j];

							}

						}

					}

					dynamic_access.put(template_21, temp_21);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_22[a]) {

							for (int j = 0; j < R; j++) {
								temp_22[a][j] = solution_22[a][j];

							}

						}

					}

					dynamic_access.put(template_22, temp_22);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_23[a]) {

							for (int j = 0; j < R; j++) {
								temp_23[a][j] = solution_23[a][j];

							}

						}

					}

					dynamic_access.put(template_23, temp_23);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_24[a]) {

							for (int j = 0; j < R; j++) {
								temp_24[a][j] = solution_24[a][j];

							}

						}
					}

					dynamic_access.put(template_24, temp_24);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_25[a]) {

							for (int j = 0; j < R; j++) {
								temp_25[a][j] = solution_25[a][j];

							}

						}
					}

					dynamic_access.put(template_25, temp_25);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_26[a]) {

							for (int j = 0; j < R; j++) {
								temp_26[a][j] = solution_26[a][j];

							}

						}

					}

					dynamic_access.put(template_26, temp_26);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_27[a]) {

							for (int j = 0; j < R; j++) {
								temp_27[a][j] = solution_27[a][j];

							}

						}

					}

					dynamic_access.put(template_27, temp_27);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_28[a]) {

							for (int j = 0; j < R; j++) {
								temp_28[a][j] = solution_28[a][j];

							}

						}

					}

					dynamic_access.put(template_28, temp_28);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_29[a]) {

							for (int j = 0; j < R; j++) {
								temp_29[a][j] = solution_29[a][j];

							}

						}

					}

					dynamic_access.put(template_29, temp_29);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_30[a]) {

							for (int j = 0; j < R; j++) {
								temp_30[a][j] = solution_30[a][j];

							}

						}

					}

					dynamic_access.put(template_30, temp_30);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_31[a]) {

							for (int j = 0; j < R; j++) {
								temp_31[a][j] = solution_31[a][j];

							}

						}

					}

					dynamic_access.put(template_31, temp_31);

					for (int a = 0; a < PATHNUM; a++) {
						if (statu_32[a]) {

							for (int j = 0; j < R; j++) {
								temp_32[a][j] = solution_32[a][j];

							}

						}
					}

					dynamic_access.put(template_32, temp_32);

					for (int temp_x = 0; temp_x < pop_num; temp_x++) {

						for (int rr = 0; rr < R; rr++) {

							temp_holder[temp_x][rr] = (x[temp_x][rr]);

						}

					}

					/*
					 * for (int row = 0; row < pop_num; row++) { for (int col = 0; col < R; col++) {
					 * x[row][col] = 0; } }
					 */
					// group_map.put(template_32, group_1_list);
					for (String group_key : group_map.keySet()) {

						if (traverse_template.charAt(0) == group_key.charAt(0)) {

							List<String> neighbor_holder = new ArrayList<String>();

							neighbor_holder = group_map.get(group_key);

							int index_getter = 0;

							// for (int holders = 0; holders < neighbor_holder.size(); holders++) {

							if (neighbor_holder.contains(traverse_template)) {

								// if (neighbor_holder.get(holders).equals(traverse_template)) {

								for (int i_1 = 0; i_1 < (dynamic_access.get(traverse_template)).length; i_1++) {

									if (index_getter < pop_num) {

										// for (int dimz = 0; dimz < (dynamic_access
										// .get(traverse_template)[i_1]).length; dimz++) {

										if (dynamic_access.get(traverse_template)[i_1][0] == 0
												&& dynamic_access.get(traverse_template)[i_1][1] == 0
										) {

											continue;
										}

										else {

											for (int dimz = 0; dimz < (dynamic_access
													.get(traverse_template)[i_1]).length; dimz++) {

												x[index_getter][dimz] = dynamic_access
														.get(traverse_template)[i_1][dimz];

											}
										}

									}

									index_getter++;
								}

								break;
							}

							for (int holder = 0; holder < neighbor_holder.size(); holder++) {

								if (!(neighbor_holder.get(holder).equals(traverse_template))) {

									String tempo = (neighbor_holder.get(holder));

									for (int i_2 = 0; i_2 < (dynamic_access.get(tempo)).length; i_2++) {

										// index_getter++;

										if (index_getter < pop_num) {

											if (dynamic_access.get(tempo)[i_2][0] == 0
													&& dynamic_access.get(tempo)[i_2][1] == 0
													) {

												continue;
											}

											else {

												for (int dimz = 0; dimz < (dynamic_access
														.get(tempo)[i_2]).length; dimz++) {

													x[index_getter][dimz] = dynamic_access.get(tempo)[i_2][dimz];

												}
											}
										}
										index_getter++;
									}

								}
							}
							/*
							 * if (index_getter < pop_num) {
							 * 
							 * int intg = index_getter;
							 * 
							 * for (int temp_t = 0; temp_t < pop_num; temp_t++) {
							 * 
							 * intg++;
							 * 
							 * if (intg < pop_num) {
							 * 
							 * for (int rr_ = 0; rr_ < R; rr_++) {
							 * 
							 * x[intg][rr_] = temp_holder[temp_t][rr_];
							 * 
							 * } } } }
							 */

							break;
						}

					}

					// }
				}

				long start_time = System.currentTimeMillis();
				long wait_time = 9375;
				long end_time = start_time + wait_time;

				while ((System.currentTimeMillis() < end_time) && start_big_time < end_main_time) // not

				{

					for (int i = 0; i < pop_num; i++) // Generate a new test case (crossover&mutation)
					{

						int k1 = (int) Math.floor(Math.random() * pop_num); // must not be same as parent
						// execute this code while K1 = i
						while (k1 == i)

							k1 = (int) Math.floor(Math.random() * pop_num);

						int k2 = (int) Math.floor(Math.random() * pop_num);

						while (k2 == i || k2 == k1) // must not be same as parent

							k2 = (int) Math.floor(Math.random() * pop_num);

						int jrand = (int) (Math.random() * R);

						for (int j = 0; j < R; j++) {

							// v[i][j] = (int) Math.round(Math.abs(x[i][j] + F * (x[k1][j] - x[k2][j]))); //
							// parent
							v[i][j] = (int) ((x[i][j] + F * (x[k1][j] - x[k2][j])));

							if (Math.random() <= Pc && j != jrand)

								v[i][j] = x[i][j];

							if (v[i][j] > ub[j] || v[i][j] < lb[j]) {
								// double r01 = Math.random();

								v[i][j] = (int) (Math.random() * ((ub[j] - lb[j]) + 1)) + lb[j];
							}
							// //("v[i][j]" + v[i][j]);

						}

						// case_num[run] = case_num[run] + 1;

						// total_case_num[run] = total_case_num[run] + 1;

						getfinalpath = pathnum(v[i]);

						traverse_1(getfinalpath, i);
					} //

					try {

						if (pathcounter.get(traverse_template) < PATHNUM) {

							if ((PATHNUM - (pathcounter.get(traverse_template)) == 1)) { // if only one uncovered path

								// break;

								// infeasible_path++;

								LinkedHashMap<String, Double> single_objective = new LinkedHashMap<String, Double>();
								// //("only one uncovered>>>>");
								double par_obj;

								double child_obj;

								for (int i = 0; i < pop_num; i++) {

									ArrayList<Double> fitnessx_ = new ArrayList<Double>();
									// align benchmark function to template to evaluate

									fitnessx_ = benchmarkfunction(x[i], traverse_template);

									// row_getter.put(offspring_population.get(get_row), row_fitter);
									par_obj = fitnessx_.get(0);
									// offspring_singleobjective

									double obj_par = par_obj;

									ArrayList<Double> fitnessv_ = new ArrayList<Double>();

									fitnessv_ = benchmarkfunction(v[i], traverse_template);

									child_obj = fitnessv_.get(0);

									double obj_ch = child_obj;

									if (obj_ch < obj_par) {

										single_objective.put(("child" + " " + i), obj_ch);

									}

									else if (obj_ch > obj_par) {

										single_objective.put(("parent" + " " + i), obj_par);

									}

									// if (obj_par == obj_ch)
									else {

										single_objective.put(("parent" + " " + i), obj_par);
										single_objective.put(("child" + " " + i), obj_ch);

									}

								}

								// double row_fitter = row_fit;

								Map<String, Double> result_ = single_objective.entrySet().stream()
										.sorted(Map.Entry.comparingByValue())
										.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
												(oldValue, newValue) -> oldValue, LinkedHashMap::new));

								Iterator<Map.Entry<String, Double>> iteration_ = result_.entrySet().iterator();

								while (iteration_.hasNext()) {

									Map.Entry<String, Double> entry = iteration_.next();

									if (single_population.size() < pop_num) {
										single_population.add(entry.getKey());
									}

								}

								String updated_id;

								int updated_val;

								// int rem;

								for (int pop = 0; pop < single_population.size(); pop++) {

									if (pop == 50) {
										break;
									}

									String[] updated_pop = (single_population.get(pop).split(" "));

									updated_id = updated_pop[0];
									updated_val = Integer.parseInt(updated_pop[1]);

									if (updated_id.equals("parent")) {
										for (int update_parent = 0; update_parent < R; update_parent++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_parent] = x[updated_val][update_parent];
										}
									}

									if (updated_id.equals("child")) {
										for (int update_child = 0; update_child < R; update_child++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_child] = v[updated_val][update_child];
										}
									}

								}

								single_population.clear();
								// Cycle[run]++;
								break;
							}

							else {

								for (int i = 0; i < pop_num; i++) {

									ArrayList<Double> fitness_objectives_temporary_x = new ArrayList<Double>();
									// align benchmark function to template to evaluate

									fitness_objectives_temporary_x = benchmarkfunction(x[i], traverse_template);

									// offspring_population.add("parent" + " " + i);

									// combined_maps.put("parent" + " " + i, fitness_objectives_temporary_x);

									// ArrayList<Double> fitnessv = new ArrayList<Double>();

									ArrayList<Double> fitness_objectives_temporary_v = new ArrayList<Double>();

									fitness_objectives_temporary_v = benchmarkfunction(v[i], traverse_template);

									// objective_size = fitness_objectives_temporary_v.size();

									// offspring_population.add("child" + " " + i);

									// fitness_nonsimple1.put("child" + " " + i,
									// fitness_objectives_temporary_v);
									// combined_maps.put("child" + " " + i, fitness_objectives_temporary_v);

									// double non_simplexx;
									// double non_simplevv
									// //(fitness_objectives_temporary_v);

									int returned_comparison_par;

									returned_comparison_par = dominace_Comparison(fitness_objectives_temporary_x,
											fitness_objectives_temporary_v);

									if (returned_comparison_par == -1) { // Solution i dominates child
										offspring_population.add("parent" + " " + i);

										// fitness_nonsimple2.put("parent" + " " + i,
										// fitness_objectives_temporary_x);
										combined_maps.put("parent" + " " + i, fitness_objectives_temporary_x);
									} // if
									else if (returned_comparison_par == 1) { // child dominates
										offspring_population.add("child" + " " + i);

										// fitness_nonsimple2.put("child" + " " + i,
										// fitness_objectives_temporary_v);
										combined_maps.put("child" + " " + i, fitness_objectives_temporary_v);
									} // else if
									else { // the two solutions are non-dominated

										// fitness_nonsimple2.put("child" + " " + i,
										// fitness_objectives_temporary_v);

										offspring_population.add("parent" + " " + i);
										offspring_population.add("child" + " " + i);
										// fitness_nonsimple2.put("parent" + " " + i,
										// fitness_objectives_temporary_x);
										combined_maps.put("parent" + " " + i, fitness_objectives_temporary_x);
										combined_maps.put("child" + " " + i, fitness_objectives_temporary_v);
									} // else

								}

								/// LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String,
								/// Double>();

								// int cols = (PATHNUM - (pathcounter.get(traverse_template)));

								int column_size = (objective_size);

								double[][] offspring_fitness_full = new double[offspring_population
										.size()][column_size];

								// String[] fit_obj;
								int updates = 0;

								while (updates < offspring_population.size()) {

									ArrayList<Double> fitness_objectives_updated = new ArrayList<Double>();

									fitness_objectives_updated
											.addAll(combined_maps.get(offspring_population.get(updates)));

									for (int ups = 0; ups < fitness_objectives_updated.size(); ups++) {

										offspring_fitness_full[updates][ups] = fitness_objectives_updated.get(ups);

									}
									fitness_objectives_updated.clear();

									updates++;

								}

								ArrayList<String> best_column = new ArrayList<String>();

								String test_case;
								double fit_rowfit;

								// combined_population_backup
								int fronts = 0;

								LinkedHashMap<String, Double> row_getter = new LinkedHashMap<String, Double>();

								ArrayList<Integer> colum_counter = new ArrayList<Integer>();

								// //("Did we get here--21");

								/// -while (!combined_population_list.isEmpty()) {}

								int added_columns = 0;

								while (added_columns < offspring_population.size()) {

									if (colum_counter.size() == column_size) {

										break;

									}

									int colums = 0;

									while (colums < column_size) {

										if (colum_counter.contains(colums)) {

											continue;

											// check if column size counter == objective size

											// and break out the main while loop

										}

										for (int get_row = 0; get_row < (offspring_population.size()); get_row++) {

											fit_rowfit = (offspring_fitness_full[get_row][colums]);

											row_getter.put(offspring_population.get(get_row), fit_rowfit);

										}

										// //("Did we get here--8");

										Map<String, Double> result = row_getter.entrySet().stream()
												.sorted(Map.Entry.comparingByValue())
												.collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
														(oldValue, newValue) -> oldValue, LinkedHashMap::new));
										// //("Map yino" +result );

										Iterator<Map.Entry<String, Double>> best_col = result.entrySet().iterator();

										while (best_col.hasNext()) {

											Map.Entry<String, Double> entry = best_col.next();

											test_case = entry.getKey();

											if (!best_column.contains(test_case)) {

												best_column.add(test_case);

												setrank1.put(test_case, fronts);

												added_columns++;
												// combined_population_list.remove(test_case);

												colum_counter.add(colums);

												break;
											}

										}

										result.clear();
										row_getter.clear();
										colums++;

									}

									fronts++;

								}

								if (!offspring_population.isEmpty()) {

									for (int get_row = 0; get_row < (offspring_population.size()); get_row++) {

										setrank1.put(offspring_population.get(get_row), fronts);

									}

								}

								// //("Did we get here--22");

								// //("Front count" +fronts);

								Map<Integer, ArrayList<String>> reverseMap = new HashMap<>();

								for (Map.Entry<String, Integer> entry : setrank1.entrySet()) {
									if (!reverseMap.containsKey(entry.getValue())) {
										reverseMap.put(entry.getValue(), new ArrayList<>());
									}
									ArrayList<String> keys = reverseMap.get(entry.getValue());
									keys.add(entry.getKey());
									reverseMap.put(entry.getValue(), keys);
								}

								// //("reverse map: "+reverseMap.size());

								for (int key_ss : reverseMap.keySet()) {

									List<String> front_list = new ArrayList<String>();

									front_list.addAll(reverseMap.get(key_ss));

									for (int next_front = 0; next_front < front_list.size(); next_front++) {

										updated_population.add(front_list.get(next_front));
									}

								}

								// //("check size " + updated_population.size());

								String updated_id;

								int updated_val;

								for (int pop = 0; pop < updated_population.size(); pop++) {

									if (pop == 50) {

										break;
									}

									String[] updated_pop = (updated_population.get(pop).split(" "));
									updated_id = updated_pop[0];
									updated_val = Integer.parseInt(updated_pop[1]);

									if (updated_id.equals("parent")) {
										for (int update_parent = 0; update_parent < R; update_parent++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_parent] = x[updated_val][update_parent];
										}
									}
									if (updated_id.equals("child")) {
										for (int update_child = 0; update_child < R; update_child++) {
											// x[i][j] = v[i][j] ;

											x[pop][update_child] = v[updated_val][update_child];
										}
									}

								}

							}
						}
					} catch (IndexOutOfBoundsException e) {

					}

					updated_population.clear();
					offspring_population.clear();
					offspring_population2.clear();
					setrank1.clear();
					setrank2.clear();
					setrank3.clear();
					combined_maps.clear();
					single_population.clear();

					/*
					 * while ((end_time - System.currentTimeMillis()) >= 0) {
					 * 
					 * 
					 * 
					 * 
					 * }
					 */
				}

			}
			// //(totalpathcounter * 100 / TOTAL_PATHNUM);
			coverage[run] = totalpathcounter * 100 / TOTAL_PATHNUM; // percentage of
			// paths covered per run
			average_coverage_count[run] = totalpathcounter;

			// //("Path coverage=" + coverage[run] + "%");
           
			Bug_data[run] = bug_one_;
			
			//timer.cancel();
			run++;
		}

		for (

				int a = 0; a < 16; a++) {

			for (int j = 0; j < RUN; j++) {

				try {

					if (convergencegraph[a][j] == 0) {

						convergencegraph[a][j] = convergencegraph[a - 1][j];
					}
				}

				catch (ArrayIndexOutOfBoundsException exception) {

				}

			}

		}
		
	try {	
		FileOutputStream fos_all_ = new FileOutputStream(bug_report);
		BufferedWriter bw_all_ = new BufferedWriter(new OutputStreamWriter(fos_all_));

		for (int j = 0; j < RUN; j++) {

			bw_all_.write(Bug_data[j]); // write to file key is the data
			bw_all_.newLine();

		}

		bw_all_.close();
	}
		/*
		 * for (int a = 0; a < 16; a++) {
		 * 
		 * for (int j = 0; j < RUN; j++) {
		 * 
		 * System.out.print(convergencegraph[a][j] + " "); } //();
		 * 
		 * }
		 */
		 catch (Exception e) {
			//(e);
		}

	}

	// 获取平均值
	static double getAverage(float[] coverage2, int num) {
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += coverage2[i];
		}
		return (double) (sum / num);
	}

	static double getAverage_count(int[] coverage_count, int num) {
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += coverage_count[i];
		}
		return (double) (sum / num);
	}

	// 标准差
	static double getStandardDevition(float[] array, int num) {
		double sum = 0;
		for (int i = 0; i < num; i++) {
			sum += Math.sqrt(((double) array[i] - getAverage(array, num)) * (array[i] - getAverage(array, num)));
		}
		return (sum / (num - 1));
	}

	public static String pathnum(int[] trix) {
		StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.append("0"); //for max array just store it. it's by default
		// assigned
		String finalpath = " ";

		boolean[][] truth_table_visit = new boolean[NODENUM][10];

		// maximum array value

		int i1;
		int bugcount = 0;

		int max;
		int a4 = trix[0]; // a4 will hold the values in the individual x
		int x1 = 0;

		// max = a4[0]; // set max value to the first element of the array

		for (int j = 0; j < 10; j++) {

			if (a4 % 2 == 0) {

				truth_table_visit[0][j] = true; // keep track of the truth node visit at the taken iteration---make
												// it true

				// truth_table_visit[1][j] = false;
				x1++;
			}

			else {

				// truth_table_visit[0][j] = false;
				truth_table_visit[1][j] = true;
				// max = a4[j];
				// truth_table_visit[1][j] = true;
				// false_count++;
				// false_table_visit[1][j] = true;
				x1 += 2;
			}

		
		}
		
		
		if(((x1 % 2 ) != (a4 % 2))){
			  
			 bugcount = bugcount+1;
		  }
		
		
	////("bug found "+bugcount);
		
		

		for (int j = 0; j < 10; j++) { // align the visits to form the correct traversed path

			if ((truth_table_visit[0][j])) {

				stringBuilder.append('a');

			}

			if ((truth_table_visit[1][j]))
				stringBuilder.append('b');

		}

		finalpath = stringBuilder.toString();
		// return finalpath;
		
		if (bugcount >= 1) {
			
			if (!bug_one) {
				
			bugrecord = 1;

			buggypath = finalpath;

			input = trix[0];

			bug_one_ = "run: " + " " + run + " " + "bug count: " + bugcount + " " + "path:   " + buggypath + " "
					+ "test input:  " + " (" + input + ")";
			bug_one = true;
		}
			
		
		}

		return finalpath; // path traversed by input/test data(x) : capture its id
	}

	public static ArrayList<Double> benchmarkfunction(int[] trix, String template_id) throws FileNotFoundException // evaluation_of_fitness_for

	{

		double[][] fitness_matrix = new double[NODENUM][10];
		ArrayList<Double> fit = new ArrayList<Double>();
		boolean[][] benchmark_table_visit = new boolean[NODENUM][10];
		// evaluate divergence at the edge of the vertex per iteration ...

		StringBuilder benchmarkBuilder = new StringBuilder();
		String final_vertex_path;

		String nonsimple_violation;

		// int pattern_counter;

		// pattern_counter = pattern_number;
		int i2;
		int i3;
		double v1 = 0;

		double v2 = 0;

		double exp = 0;
		double exp_1 = 0;
		double total_1 = 0.0;

		// double matched_percentage = 0.0;
		int max1;
		// double unwinding1 = 0.0;
		// double unwinding2 = 0.0;;
		// double unwinding1 = 0.0;
		// double unwinding2 = 0.0;
		double simple_unwinding = 0.0;

		int max2;
		// int[] a5 = new int[R];
		// int[] a6 = new int[R];
		//fitness_matrix[0][0] = Double.MAX_VALUE;
		//fitness_matrix[1][0] = Double.MAX_VALUE;
		// total_violation = 0.0;
		// Unmatched_branch_node_1 = 0;
		// total_1 = 0.0;

		int x1 = 0;
		int a5 = trix[0];
		int a6 = trix[0];

		// max1 = a5[0];

		for (int j = 0; j < 10; j++) {

			if (a5 % 2 == 0) {

				v1 = 0.0;

				fitness_matrix[0][j] = v1;

				x1++;
			}

			else {

				v1 = Math.abs(a5 - 0) + bias;

				exp = (v1 / (v1 + 1));

				fitness_matrix[0][j] = exp;

				x1 += 2;
			}

		}

		for (int j = 0; j < 10; j++) {

			if (a6 % 2 != 0) {

				v2 = 0.0;

				fitness_matrix[1][j] = v2;

			}

			else {

				v2 = bias;

				// exp_1 = Math.pow(1.001, -(v2)); // normalize_branch_distance

				exp_1 = (v2 / (v2 + 1));

				// fitness_matrix[1][j] = (1 - exp_1);

				fitness_matrix[1][j] = exp_1;

			}

		}

		int i1;
		int max_;

		int x2 = 0;

		int a4_ = trix[0];

		// max_ = a4_[0];

		for (int j = 0; j < 10; j++) {

			if (a4_ % 2 == 0) {

				benchmark_table_visit[0][j] = true;
				// truth_count++;

			}

			else {

				// max = a4[j];
				benchmark_table_visit[1][j] = true;
				// false_count++;
				// false_table_visit[1][j] = true;

			}

		}
		// construct traversed vertex string

		for (int j = 0; j < 10; j++) {

			if ((benchmark_table_visit[0][j])) {

				benchmarkBuilder.append('a');

			}

			if ((benchmark_table_visit[1][j])) {
				benchmarkBuilder.append('b');

			}
		}

		final_vertex_path = benchmarkBuilder.toString();

		// String temp_path;

		nonsimple_violation = final_vertex_path.substring(0, Math.min(final_vertex_path.length(), pattern_number));
		// //("paths---2" + final_vertex_path);

		String strLine_non_simple;
		// fit.add(non_simpleid);

		Iterator<Map.Entry<String, Boolean>> iter_simple = temporary_path_holder.entrySet().iterator();

		while (iter_simple.hasNext()) {

			Map.Entry<String, Boolean> entry = iter_simple.next();

			strLine_non_simple = entry.getKey();

			if (!paths.get(strLine_non_simple)) {

				double Unmatched_branch_node_a = 0.0;
				double Unmatched_branch_node_b = 0.0;
				// traversed_violation = strLine_non.substring(strLine_non.length() - 5);

				// int index = 0;
				// double unwinding2 = 0.0;
				for (int i_1 = 0; i_1 < 10; i_1++) {

					if (final_vertex_path.charAt(i_1) != strLine_non_simple.charAt(i_1)) {

						if (strLine_non_simple.charAt(i_1) == 'a') {

							Unmatched_branch_node_a += fitness_matrix[0][i_1];

						}

						if (strLine_non_simple.charAt(i_1) == 'b') {

							Unmatched_branch_node_b += fitness_matrix[1][i_1];

						}

					}

				}
				double nonsimple_unmatched2 = 0.0;
				nonsimple_unmatched2 = Unmatched_branch_node_a + Unmatched_branch_node_b;
				fit.add(nonsimple_unmatched2);
			}

		}

		return fit;

	}

	static void enumeratePaths(int k, char[] set, char[] str, int index) {
		if (index == k) {
			// //(new String(str));
			paths.put(new String(str), false); // write all resulting paths to map..

		} else {
			for (int i = 0; i < set.length; i++) {
				str[index] = set[i];
				enumeratePaths(k, set, str, index + 1); // recursive procedure to enumerate the paths.
			}
		}
	}

	public static void init_Template() throws IOException {
		FileOutputStream fos_all = new FileOutputStream(allpaths);
		BufferedWriter bw_all = new BufferedWriter(new OutputStreamWriter(fos_all));

		FileOutputStream fos_1 = new FileOutputStream(id_1);
		BufferedWriter bw_1 = new BufferedWriter(new OutputStreamWriter(fos_1));

		FileOutputStream fos_2 = new FileOutputStream(id_2);
		BufferedWriter bw_2 = new BufferedWriter(new OutputStreamWriter(fos_2));

		FileOutputStream fos_3 = new FileOutputStream(id_3);
		BufferedWriter bw_3 = new BufferedWriter(new OutputStreamWriter(fos_3));

		FileOutputStream fos_4 = new FileOutputStream(id_4);
		BufferedWriter bw_4 = new BufferedWriter(new OutputStreamWriter(fos_4));

		FileOutputStream fos_5 = new FileOutputStream(id_5);
		BufferedWriter bw_5 = new BufferedWriter(new OutputStreamWriter(fos_5));

		FileOutputStream fos_6 = new FileOutputStream(id_6);
		BufferedWriter bw_6 = new BufferedWriter(new OutputStreamWriter(fos_6));

		FileOutputStream fos_7 = new FileOutputStream(id_7);
		BufferedWriter bw_7 = new BufferedWriter(new OutputStreamWriter(fos_7));

		FileOutputStream fos_8 = new FileOutputStream(id_8);
		BufferedWriter bw_8 = new BufferedWriter(new OutputStreamWriter(fos_8));

		FileOutputStream fos_9 = new FileOutputStream(id_9);
		BufferedWriter bw_9 = new BufferedWriter(new OutputStreamWriter(fos_9));

		FileOutputStream fos_10 = new FileOutputStream(id_10);
		BufferedWriter bw_10 = new BufferedWriter(new OutputStreamWriter(fos_10));

		FileOutputStream fos_11 = new FileOutputStream(id_11);
		BufferedWriter bw_11 = new BufferedWriter(new OutputStreamWriter(fos_11));

		FileOutputStream fos_12 = new FileOutputStream(id_12);
		BufferedWriter bw_12 = new BufferedWriter(new OutputStreamWriter(fos_12));

		FileOutputStream fos_13 = new FileOutputStream(id_13);
		BufferedWriter bw_13 = new BufferedWriter(new OutputStreamWriter(fos_13));

		FileOutputStream fos_14 = new FileOutputStream(id_14);
		BufferedWriter bw_14 = new BufferedWriter(new OutputStreamWriter(fos_14));

		FileOutputStream fos_15 = new FileOutputStream(id_15);
		BufferedWriter bw_15 = new BufferedWriter(new OutputStreamWriter(fos_15));

		FileOutputStream fos_16 = new FileOutputStream(id_16);
		BufferedWriter bw_16 = new BufferedWriter(new OutputStreamWriter(fos_16));

		FileOutputStream fos_17 = new FileOutputStream(id_17);
		BufferedWriter bw_17 = new BufferedWriter(new OutputStreamWriter(fos_17));

		FileOutputStream fos_18 = new FileOutputStream(id_18);
		BufferedWriter bw_18 = new BufferedWriter(new OutputStreamWriter(fos_18));

		FileOutputStream fos_19 = new FileOutputStream(id_19);
		BufferedWriter bw_19 = new BufferedWriter(new OutputStreamWriter(fos_19));

		FileOutputStream fos_20 = new FileOutputStream(id_20);
		BufferedWriter bw_20 = new BufferedWriter(new OutputStreamWriter(fos_20));

		FileOutputStream fos_21 = new FileOutputStream(id_21);
		BufferedWriter bw_21 = new BufferedWriter(new OutputStreamWriter(fos_21));

		FileOutputStream fos_22 = new FileOutputStream(id_22);
		BufferedWriter bw_22 = new BufferedWriter(new OutputStreamWriter(fos_22));

		FileOutputStream fos_23 = new FileOutputStream(id_23);
		BufferedWriter bw_23 = new BufferedWriter(new OutputStreamWriter(fos_23));

		FileOutputStream fos_24 = new FileOutputStream(id_24);
		BufferedWriter bw_24 = new BufferedWriter(new OutputStreamWriter(fos_24));

		FileOutputStream fos_25 = new FileOutputStream(id_25);
		BufferedWriter bw_25 = new BufferedWriter(new OutputStreamWriter(fos_25));

		FileOutputStream fos_26 = new FileOutputStream(id_26);
		BufferedWriter bw_26 = new BufferedWriter(new OutputStreamWriter(fos_26));

		FileOutputStream fos_27 = new FileOutputStream(id_27);
		BufferedWriter bw_27 = new BufferedWriter(new OutputStreamWriter(fos_27));

		FileOutputStream fos_28 = new FileOutputStream(id_28);
		BufferedWriter bw_28 = new BufferedWriter(new OutputStreamWriter(fos_28));

		FileOutputStream fos_29 = new FileOutputStream(id_29);
		BufferedWriter bw_29 = new BufferedWriter(new OutputStreamWriter(fos_29));

		FileOutputStream fos_30 = new FileOutputStream(id_30);
		BufferedWriter bw_30 = new BufferedWriter(new OutputStreamWriter(fos_30));

		FileOutputStream fos_31 = new FileOutputStream(id_31);
		BufferedWriter bw_31 = new BufferedWriter(new OutputStreamWriter(fos_31));

		FileOutputStream fos_32 = new FileOutputStream(id_32);
		BufferedWriter bw_32 = new BufferedWriter(new OutputStreamWriter(fos_32));

		Set<String> keyz = paths.keySet();

		for (String key : keyz) {

			bw_all.write(key); // write to file
			bw_all.newLine();

			if (key.startsWith("aaaaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_1.write(key); // write to file
				bw_1.newLine();

				// group2.put(key, false);

				if (!pathcounter.containsKey("aaaaa")) {

					pathcounter.put("aaaaa", 0);
					evaluated_status.put("aaaaa", false);
					/// groups.add("aaaaa");
				}

			}

			if (key.startsWith("aaaab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_2.write(key); // write to file
				bw_2.newLine();

				// group2.put(key, false);

				if (!pathcounter.containsKey("aaaab")) {

					pathcounter.put("aaaab", 0);
					evaluated_status.put("aaaab", false);
					// groups.add("aaaab");
				}

			}

			if (key.startsWith("aaaba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_3.write(key); // write to file
				bw_3.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("aaaba")) {

					pathcounter.put("aaaba", 0);
					evaluated_status.put("aaaba", false);
					// groups.add("aaaba");
				}

			}

			if (key.startsWith("aaabb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_4.write(key); // write to file
				bw_4.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("aaabb")) {

					pathcounter.put("aaabb", 0);
					evaluated_status.put("aaabb", false);
					// groups.add("aaabb");
				}

			}

			if (key.startsWith("aabaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_5.write(key); // write to file
				bw_5.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("aabaa")) {

					pathcounter.put("aabaa", 0);
					evaluated_status.put("aabaa", false);
					// groups.add("aabaa");
				}

			}

			if (key.startsWith("aabab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_6.write(key); // write to file
				bw_6.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("aabab")) {

					pathcounter.put("aabab", 0);
					evaluated_status.put("aabab", false);
					// groups.add("aabab");
				}

			}

			if (key.startsWith("aabba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_7.write(key); // write to file
				bw_7.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("aabba")) {

					pathcounter.put("aabba", 0);
					evaluated_status.put("aabba", false);
					// groups.add("aabba");
				}

			}

			if (key.startsWith("aabbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_8.write(key); // write to file
				bw_8.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("aabbb")) {

					pathcounter.put("aabbb", 0);
					evaluated_status.put("aabbb", false);
					// groups.add("aabbb");
				}

			}

			if (key.startsWith("abaaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_9.write(key); // write to file
				bw_9.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("abaaa")) {

					pathcounter.put("abaaa", 0);
					evaluated_status.put("abaaa", false);
					// groups.add("abaaa");
				}

			}

			if (key.startsWith("abaab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_10.write(key); // write to file
				bw_10.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("abaab")) {

					pathcounter.put("abaab", 0);
					evaluated_status.put("abaab", false);
					// groups.add("abaab");
				}

			}

			if (key.startsWith("ababa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_11.write(key); // write to file
				bw_11.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("ababa")) {

					pathcounter.put("ababa", 0);
					evaluated_status.put("ababa", false);
					// groups.add("ababa");
				}

			}

			if (key.startsWith("ababb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_12.write(key); // write to file
				bw_12.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("ababb")) {

					pathcounter.put("ababb", 0);
					evaluated_status.put("ababb", false);
					// groups.add("ababb");
				}
			}

			if (key.startsWith("abbaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_13.write(key); // write to file
				bw_13.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("abbaa")) {

					pathcounter.put("abbaa", 0);
					evaluated_status.put("abbaa", false);
					// groups.add("abbaa");
				}

			}

			if (key.startsWith("abbab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_14.write(key); // write to file
				bw_14.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("abbab")) {

					pathcounter.put("abbab", 0);
					evaluated_status.put("abbab", false);
					// groups.add("abbab");
				}

			}

			if (key.startsWith("abbba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_15.write(key); // write to file
				bw_15.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("abbba")) {

					pathcounter.put("abbba", 0);
					evaluated_status.put("abbba", false);
					// groups.add("abbba");

				}

			}

			if (key.startsWith("abbbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_16.write(key); // write to file
				bw_16.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("abbbb")) {

					pathcounter.put("abbbb", 0);
					evaluated_status.put("abbbb", false);
					// groups.add("abbbb");

				}

			}

			if (key.startsWith("baaaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_17.write(key); // write to file
				bw_17.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("baaaa")) {

					pathcounter.put("baaaa", 0);
					evaluated_status.put("baaaa", false);
					// groups.add("baaaa");
				}

			}

			/*******************************************************************************************************/

			if (key.startsWith("baaab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_18.write(key); // write to file
				bw_18.newLine();
				// group3.put(key, false);
				if (!pathcounter.containsKey("baaab")) {

					pathcounter.put("baaab", 0);
					evaluated_status.put("baaab", false);
					// groups.add("baaab");
				}

			}

			if (key.startsWith("baaba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_19.write(key); // write to file
				bw_19.newLine();

				// group4.put(key, false);

				if (!pathcounter.containsKey("baaba")) {

					pathcounter.put("baaba", 0);
					evaluated_status.put("baaba", false);
					// groups.add("baaba");
				}

			}

			if (key.startsWith("baabb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_20.write(key); // write to file
				bw_20.newLine();

				// group5.put(key, false);

				if (!pathcounter.containsKey("baabb")) {

					pathcounter.put("baabb", 0);
					evaluated_status.put("baabb", false);
					// groups.add("baabb");
				}

			}

			if (key.startsWith("babaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_21.write(key); // write to file
				bw_21.newLine();

				// group6.put(key, false);

				if (!pathcounter.containsKey("babaa")) {

					pathcounter.put("babaa", 0);
					evaluated_status.put("babaa", false);
					// groups.add("babaa");
				}

			}

			if (key.startsWith("babab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_22.write(key); // write to file
				bw_22.newLine();

				// group7.put(key, false);

				if (!pathcounter.containsKey("babab")) {

					pathcounter.put("babab", 0);
					evaluated_status.put("babab", false);
					// groups.add("babab");
				}

			}

			if (key.startsWith("babba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_23.write(key); // write to file
				bw_23.newLine();

				// group8.put(key, false);
				//
				if (!pathcounter.containsKey("babba")) {

					pathcounter.put("babba", 0);
					evaluated_status.put("babba", false);
					// groups.add("babba");
				} //

			}

			if (key.startsWith("babbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_24.write(key); // write to file
				bw_24.newLine();

				// group9.put(key, false);
				//
				if (!pathcounter.containsKey("babbb")) {

					pathcounter.put("babbb", 0);
					evaluated_status.put("babbb", false);
					// groups.add("babbb");
				}

			}

			if (key.startsWith("bbaaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_25.write(key); // write to file
				bw_25.newLine();

				// group10.put(key, false);

				if (!pathcounter.containsKey("bbaaa")) {

					pathcounter.put("bbaaa", 0);
					evaluated_status.put("bbaaa", false);
					// groups.add("bbaaa");
				}

			}

			if (key.startsWith("bbaab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_26.write(key); // write to file
				bw_26.newLine();

				// group11.put(key, false);

				if (!pathcounter.containsKey("bbaab")) {

					pathcounter.put("bbaab", 0);
					evaluated_status.put("bbaab", false);
					// groups.add("bbaab");
				}

			}

			if (key.startsWith("bbaba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_27.write(key); // write to file
				bw_27.newLine();

				// group12.put(key, false);

				if (!pathcounter.containsKey("bbaba")) {

					pathcounter.put("bbaba", 0);
					evaluated_status.put("bbaba", false);
					// groups.add("bbaba");
				}
			}

			if (key.startsWith("bbabb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_28.write(key); // write to file
				bw_28.newLine();

				// group13.put(key, false);

				if (!pathcounter.containsKey("bbabb")) {

					pathcounter.put("bbabb", 0);
					evaluated_status.put("bbabb", false);
					// groups.add("bbabb");
				}

			}

			if (key.startsWith("bbbaa")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_29.write(key); // write to file
				bw_29.newLine();

				// group14.put(key, false);

				if (!pathcounter.containsKey("bbbaa")) {

					pathcounter.put("bbbaa", 0);
					evaluated_status.put("bbbaa", false);
					// groups.add("bbbaa");
				}

			}

			if (key.startsWith("bbbab")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_30.write(key); // write to file
				bw_30.newLine();

				// group15.put(key, false);

				if (!pathcounter.containsKey("bbbab")) {

					pathcounter.put("bbbab", 0);
					evaluated_status.put("bbbab", false);
					// groups.add("bbbab");

				}

			}

			if (key.startsWith("bbbba")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_31.write(key); // write to file
				bw_31.newLine();

				// group16.put(key, false);

				// evaluated_status
				if (!pathcounter.containsKey("bbbba")) {

					pathcounter.put("bbbba", 0);
					evaluated_status.put("bbbba", false);
					// groups.add("bbbba");
				}

			}

			if (key.startsWith("bbbbb")) {
				// templatemap_1.put(key, false);

				// visited_nonsimplecounter.put(traversed_pattern3,0);
				bw_32.write(key); // write to file
				bw_32.newLine();
				// group1.put(key, false);

				if (!pathcounter.containsKey("bbbbb")) {

					pathcounter.put("bbbbb", 0);
					evaluated_status.put("bbbbb", false);
					// groups.add("bbbbb");
				}

			}
			/***********************************************************************************************************/

			continue;
		}

		bw_all.close();
		bw_1.close();
		bw_2.close();
		bw_3.close();
		bw_4.close();
		bw_5.close();
		bw_6.close();
		bw_7.close();
		bw_8.close();
		bw_9.close();
		bw_10.close();
		bw_11.close();
		bw_12.close();
		bw_13.close();
		bw_14.close();
		bw_15.close();
		bw_16.close();
		bw_17.close();
		bw_18.close();
		bw_19.close();
		bw_20.close();
		bw_21.close();
		bw_22.close();
		bw_23.close();
		bw_24.close();
		bw_25.close();
		bw_26.close();
		bw_27.close();
		bw_28.close();
		bw_29.close();
		bw_30.close();
		bw_31.close();
		bw_32.close();
	}

	public static void reset_All() {
		// clear all the maps for next run and update them
		paths.clear();
		pathcounter.clear();
		combined_maps.clear();
		evaluated_status.clear();
		dynamic_access.clear();

		pathcounter.put(template_1, 0);
		pathcounter.put(template_2, 0);
		pathcounter.put(template_3, 0);
		pathcounter.put(template_4, 0);
		pathcounter.put(template_5, 0);
		pathcounter.put(template_6, 0);
		pathcounter.put(template_7, 0);
		pathcounter.put(template_8, 0);
		pathcounter.put(template_9, 0);
		pathcounter.put(template_10, 0);
		pathcounter.put(template_11, 0);
		pathcounter.put(template_12, 0);
		pathcounter.put(template_13, 0);
		pathcounter.put(template_14, 0);
		pathcounter.put(template_15, 0);
		pathcounter.put(template_16, 0);
		pathcounter.put(template_17, 0);
		pathcounter.put(template_18, 0);
		pathcounter.put(template_19, 0);
		pathcounter.put(template_20, 0);
		pathcounter.put(template_21, 0);
		pathcounter.put(template_22, 0);
		pathcounter.put(template_23, 0);
		pathcounter.put(template_24, 0);
		pathcounter.put(template_25, 0);
		pathcounter.put(template_26, 0);
		pathcounter.put(template_27, 0);
		pathcounter.put(template_28, 0);
		pathcounter.put(template_29, 0);
		pathcounter.put(template_30, 0);
		pathcounter.put(template_31, 0);
		pathcounter.put(template_32, 0);

		evaluated_status.put(template_1, false);
		evaluated_status.put(template_2, false);
		evaluated_status.put(template_3, false);
		evaluated_status.put(template_4, false);
		evaluated_status.put(template_5, false);
		evaluated_status.put(template_6, false);
		evaluated_status.put(template_7, false);
		evaluated_status.put(template_8, false);
		evaluated_status.put(template_9, false);
		evaluated_status.put(template_10, false);
		evaluated_status.put(template_11, false);
		evaluated_status.put(template_12, false);
		evaluated_status.put(template_13, false);
		evaluated_status.put(template_14, false);
		evaluated_status.put(template_15, false);
		evaluated_status.put(template_16, false);
		evaluated_status.put(template_17, false);
		evaluated_status.put(template_18, false);
		evaluated_status.put(template_19, false);
		evaluated_status.put(template_20, false);
		evaluated_status.put(template_21, false);
		evaluated_status.put(template_22, false);
		evaluated_status.put(template_23, false);
		evaluated_status.put(template_24, false);
		evaluated_status.put(template_25, false);
		evaluated_status.put(template_26, false);
		evaluated_status.put(template_27, false);
		evaluated_status.put(template_28, false);
		evaluated_status.put(template_29, false);
		evaluated_status.put(template_30, false);
		evaluated_status.put(template_31, false);
		evaluated_status.put(template_32, false);

		// reload the path map with all the paths
		try {
			File fstream_temporary = new File(location + "All.txt");
			FileReader fileReader_ = new FileReader(fstream_temporary);
			BufferedReader br_ = new BufferedReader(fileReader_);
			String strLine_temporary;

			while ((strLine_temporary = br_.readLine()) != null) {

				paths.put(strLine_temporary, false);

			}
			br_.close();
		} catch (Exception e) {
		}

	}

	static double getAverage(int[] array, int num) {
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += array[i];
		}
		return (double) (sum / num);
	}

	// ��׼��
	static double getStandardDevition(int[] array, int num) {
		double sum = 0;
		for (int i = 0; i < num; i++) {
			sum += Math.sqrt(((double) array[i] - getAverage(array, num)) * (array[i] - getAverage(array, num)));
		}
		return (sum / (num - 1));
	}

	public static int dominace_Comparison(List<Double> listxobjectives, List<Double> listvobjectives) {

		// LinkedHashMap<String, Integer> counter = new LinkedHashMap<String,
		// Integer>();
		int dominatex = 0; // dominate1 indicates if some objective of solution1
		// dominates the same objective in solution2. dominate2
		int dominatev = 0;
		int dominat_flagx = 0;
		int dominat_flagv = 0;
		// dominatex = 0;
		// dominatev = 0;
		int flag;

		int count_on3x = 0;
		int count_on3y = 0;
		int objectivexcount = 0;
		int objectivevcount = 0;
		int objectivexfalsecount = 0;
		int objectivevfalsecount = 0;

		// if (listxobjectives.size() != listvobjectives.size()) {
		// return -1;
		// }

		for (int i = 0; i < listxobjectives.size(); i++) {

			if (listxobjectives.get(i) == listvobjectives.get(i)) {

				objectivexcount++;

			}

			if (listxobjectives.get(i) < listvobjectives.get(i)) {

				dominat_flagx = 1;
				objectivexcount++;
			}

			if (listxobjectives.get(i) > listvobjectives.get(i)) {

				objectivexfalsecount = 1;

			}

		}

		for (int i = 0; i < listvobjectives.size(); i++) {

			if (listvobjectives.get(i) == listxobjectives.get(i)) {

				objectivevcount++;

			}

			if (listvobjectives.get(i) < listxobjectives.get(i)) {

				dominat_flagv = 1;
				objectivevcount++;
			}

			if (listvobjectives.get(i) > listxobjectives.get(i)) {

				objectivevfalsecount = 1;

				// if any value is greater
			}
		}

		if ((objectivexcount == listxobjectives.size() && objectivexfalsecount == 0) && dominat_flagx == 1) {

			return -1; // Testcase1 dominates
		}

		else if ((objectivevcount == listvobjectives.size() && objectivevfalsecount == 0) && dominat_flagv == 1) {

			return 1; // Testcase2 dominates
		}

		else {
			return 0;
		}
		/// No one dominate the other

	}

	public static int frontdominace_Comparison(List<Double> listxobjectives, List<Double> listvobjectives) {

		int dominat_flagx = 0;
		int dominat_flagv = 0;

		int objectivexcount = 0;
		int objectivevcount = 0;
		int objectivexfalsecount = 0;
		int objectivevfalsecount = 0;

		for (int i = 0; i < listxobjectives.size(); i++) {

			if (listxobjectives.get(i) == listvobjectives.get(i)) {

				objectivexcount++;

			}

			if (listxobjectives.get(i) < listvobjectives.get(i)) {

				dominat_flagx = 1;
				objectivexcount++;
			}

			if (listxobjectives.get(i) > listvobjectives.get(i)) {

				objectivexfalsecount = 1;

			}

		}

		for (int i = 0; i < listvobjectives.size(); i++) {

			if (listvobjectives.get(i) == listxobjectives.get(i)) {

				objectivevcount++;

			}

			if (listvobjectives.get(i) < listxobjectives.get(i)) {

				dominat_flagv = 1;
				objectivevcount++;
			}

			if (listvobjectives.get(i) > listxobjectives.get(i)) {

				objectivevfalsecount = 1;

			}
		}

		if ((objectivexcount == listxobjectives.size() && objectivexfalsecount == 0) && dominat_flagx == 1) {

			return -1; // Testcase1 dominates
		}

		else if ((objectivevcount == listvobjectives.size() && objectivevfalsecount == 0) && dominat_flagv == 1) {

			return 1; // Testcase2 dominates
		}

		else {
			return 0;
		}
		/// No one dominate the other

	}

	public static int get_count(List<Double> dominatx, List<Double> dominaty) {

		int objectivedominaty = 0;

		for (int i = 0; i < dominatx.size(); i++) {

			if (dominatx.get(i) > dominaty.get(i)) {

				objectivedominaty++;

			}

		}

		return objectivedominaty;
	}

	public static void traverse(String getfinalpath, int i) {
		String final_path_checker = getfinalpath;

		if (final_path_checker.startsWith(template_1)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_1 = new File(location + "aaaaa.txt");
				FileReader fileReader_1 = new FileReader(file_1);
				BufferedReader br_1 = new BufferedReader(fileReader_1);

				String strLine_1;

				int counter1 = -1;
				while ((strLine_1 = br_1.readLine()) != null) {
					// Print the paths in this group to the console
					// // (strLine);
					counter1++;

					if (strLine_1.equals(getfinalpath)) {

						if (paths.get(strLine_1)) {
							break;
						}

						else {
							paths.put(strLine_1, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_1);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_1, fin_31);

							if (!statu_1[counter1]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_1[counter1][s] = x[i][s];

								}
								statu_1[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_1++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_1.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_2)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_2 = new File(location + "aaaab.txt");
				FileReader fileReader_2 = new FileReader(file_2);
				BufferedReader br_2 = new BufferedReader(fileReader_2);

				String strLine_2;
				// Read File Line By Line

				int counter2 = -1;
				while ((strLine_2 = br_2.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter2++;
					if (strLine_2.equals(getfinalpath)) {

						if (paths.get(strLine_2)) {
							break;
						} else {
							paths.put(strLine_2, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_2);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_2, fin_32);

							// break;

							if (!statu_2[counter2]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_2[counter2][s] = x[i][s];

								}
								statu_2[counter2] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_2++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_2.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_3)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_3 = new File(location + "aaaba.txt");
				FileReader fileReader_3 = new FileReader(file_3);
				BufferedReader br_3 = new BufferedReader(fileReader_3);

				String strLine_3;
				// Read File Line By Line
				// int counter1 = -1;
				int counter3 = -1;
				while ((strLine_3 = br_3.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter3++;
					if (strLine_3.equals(getfinalpath)) {

						if (paths.get(strLine_3)) {
							break;
						}

						else {
							paths.put(strLine_3, true);

							int xxi = 0;
							int valz = pathcounter.get(template_3);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_3, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_3[counter3]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_3[counter3][s] = x[i][s];

								}
								statu_3[counter3] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_3++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_3.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_4)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_4 = new File(location + "aaabb.txt");
				FileReader fileReader_4 = new FileReader(file_4);
				BufferedReader br_4 = new BufferedReader(fileReader_4);

				String strLine_4;
				// Read File Line By Line
				// int counter1 = -1;
				int counter4 = -1;
				while ((strLine_4 = br_4.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter4++;
					if (strLine_4.equals(getfinalpath)) {

						if (paths.get(strLine_4)) {
							break;
						} else {
							paths.put(strLine_4, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_4);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_4, fin_34);

							if (!statu_4[counter4]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_4[counter4][s] = x[i][s];

								}
								statu_4[counter4] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_4++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_4.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_5)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_5 = new File(location + "aabaa.txt");
				FileReader fileReader_5 = new FileReader(file_5);
				BufferedReader br_5 = new BufferedReader(fileReader_5);

				String strLine_5;
				// Read File Line By Line
				// int counter1 = -1;
				int counter5 = -1;
				while ((strLine_5 = br_5.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter5++;
					if (strLine_5.equals(getfinalpath)) {
						if (paths.get(strLine_5)) {
							break;
						}

						else {
							paths.put(strLine_5, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_5);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_5, fin_35);

							if (!statu_5[counter5]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_5[counter5][s] = x[i][s];

								}
								statu_5[counter5] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_5++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_5.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_6)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_6 = new File(location + "aabab.txt");
				FileReader fileReader_6 = new FileReader(file_6);
				BufferedReader br_6 = new BufferedReader(fileReader_6);

				String strLine_6;
				// Read File Line By Line
				// int counter1 = -1;
				int counter6 = -1;
				while ((strLine_6 = br_6.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter6++;
					if (strLine_6.equals(getfinalpath)) {

						if (paths.get(strLine_6)) {
							break;
						} else {
							paths.put(strLine_6, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_6);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_6, fin_36);

							if (!statu_6[counter6]) {

								for (int s = 0; s < R; s++) {

									solution_6[counter6][s] = x[i][s];

								}
								statu_6[counter6] = true; //
								obj_6++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_6.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_7)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_7 = new File(location + "aabba.txt");
				FileReader fileReader_7 = new FileReader(file_7);
				BufferedReader br_7 = new BufferedReader(fileReader_7);

				String strLine_7;
				// Read File Line By Line
				// int counter1 = -1;
				int counter7 = -1;
				while ((strLine_7 = br_7.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter7++;
					if (strLine_7.equals(getfinalpath)) {
						if (paths.get(strLine_7)) {
							break;
						}

						else {
							paths.put(strLine_7, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_7);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_7, fin_37);

							if (!statu_7[counter7]) {

								for (int s = 0; s < R; s++) {

									solution_7[counter7][s] = x[i][s];

								}
								statu_7[counter7] = true; //
								obj_7++;
								totalpathcounter++;

								break;
							}
						}
					}

				}
				fileReader_7.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_8)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_8 = new File(location + "aabbb.txt");
				FileReader fileReader_8 = new FileReader(file_8);
				BufferedReader br_8 = new BufferedReader(fileReader_8);

				String strLine_8;
				// Read File Line By Line
				// int counter1 = -1;
				int counter8 = -1;
				while ((strLine_8 = br_8.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter8++;
					if (strLine_8.equals(getfinalpath)) {
						if (paths.get(strLine_8)) {
							break;
						} else {
							paths.put(strLine_8, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_8);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_8, fin_38);

							if (!statu_8[counter8]) {

								for (int s = 0; s < R; s++) {

									solution_8[counter8][s] = x[i][s];

								}
								statu_8[counter8] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_8++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_8.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_9)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_9 = new File(location + "abaaa.txt");
				FileReader fileReader_9 = new FileReader(file_9);
				BufferedReader br_9 = new BufferedReader(fileReader_9);

				String strLine_9;
				// Read File Line By Line
				// int counter1 = -1;
				int counter9 = -1;
				while ((strLine_9 = br_9.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter9++;
					if (strLine_9.equals(getfinalpath)) {
						if (paths.get(strLine_9)) {
							break;
						}

						else {
							paths.put(strLine_9, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_9);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_9, fin_39);

							if (!statu_9[counter9]) {

								for (int s = 0; s < R; s++) {

									solution_9[counter9][s] = x[i][s];

								}
								statu_9[counter9] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_9++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_9.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_10)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_10 = new File(location + "abaab.txt");
				FileReader fileReader_10 = new FileReader(file_10);
				BufferedReader br_10 = new BufferedReader(fileReader_10);

				String strLine_10;
				// Read File Line By Line
				// int counter1 = -1;
				int counter10 = -1;
				while ((strLine_10 = br_10.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter10++;
					if (strLine_10.equals(getfinalpath)) {
						if (paths.get(strLine_10)) {
							break;
						} else {
							paths.put(strLine_10, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_10);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_10, fin_40);

							if (!statu_10[counter10]) {

								for (int s = 0; s < R; s++) {

									solution_10[counter10][s] = x[i][s];

								}
								statu_10[counter10] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_10++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_10.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_11)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_11 = new File(location + "ababa.txt");
				FileReader fileReader_11 = new FileReader(file_11);
				BufferedReader br_11 = new BufferedReader(fileReader_11);

				String strLine_11;
				// Read File Line By Line
				// int counter1 = -1;
				int counter11 = -1;
				while ((strLine_11 = br_11.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter11++;
					if (strLine_11.equals(getfinalpath)) {
						if (paths.get(strLine_11)) {
							break;
						} else {
							paths.put(strLine_11, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_11);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_11, fin_41);

							if (!statu_11[counter11]) {

								for (int s = 0; s < R; s++) {

									solution_11[counter11][s] = x[i][s];

								}
								statu_11[counter11] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_11++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_11.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_12)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_12 = new File(location + "ababb.txt");
				FileReader fileReader_12 = new FileReader(file_12);
				BufferedReader br_12 = new BufferedReader(fileReader_12);

				String strLine_12;
				// Read File Line By Line
				// int counter1 = -1;
				int counter12 = -1;
				while ((strLine_12 = br_12.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter12++;
					if (strLine_12.equals(getfinalpath)) {

						if (paths.get(strLine_12)) {
							break;
						} else {
							paths.put(strLine_12, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_12);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_12, fin_42);

							if (!statu_12[counter12]) {

								for (int s = 0; s < R; s++) {

									solution_12[counter12][s] = x[i][s];

								}
								statu_12[counter12] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_12++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}

				}
				fileReader_12.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_13)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_13 = new File(location + "abbaa.txt");
				FileReader fileReader_13 = new FileReader(file_13);
				BufferedReader br_13 = new BufferedReader(fileReader_13);

				String strLine_13;
				// Read File Line By Line
				// int counter1 = -1;
				int counter13 = -1;
				while ((strLine_13 = br_13.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter13++;
					if (strLine_13.equals(getfinalpath)) {
						if (paths.get(strLine_13)) {
							break;
						} else {
							paths.put(strLine_13, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_13);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_13, fin_43);

							if (!statu_13[counter13]) {

								for (int s = 0; s < R; s++) {

									solution_13[counter13][s] = x[i][s];

								}
								statu_13[counter13] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_13++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_13.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_14)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_14 = new File(location + "abbab.txt");
				FileReader fileReader_14 = new FileReader(file_14);
				BufferedReader br_14 = new BufferedReader(fileReader_14);

				String strLine_14;
				// Read File Line By Line
				// int counter1 = -1;
				int counter14 = -1;
				while ((strLine_14 = br_14.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter14++;
					if (strLine_14.equals(getfinalpath)) {
						if (paths.get(strLine_14)) {
							break;
						} else {
							paths.put(strLine_14, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_14);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_14, fin_44);

							if (!statu_14[counter14]) {

								for (int s = 0; s < R; s++) {

									solution_14[counter14][s] = x[i][s];

								}
								statu_14[counter14] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_14++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_14.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_15)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_15 = new File(location + "abbba.txt");
				FileReader fileReader_15 = new FileReader(file_15);
				BufferedReader br_15 = new BufferedReader(fileReader_15);

				String strLine_15;
				// Read File Line By Line
				// int counter1 = -1;
				int counter15 = -1;
				while ((strLine_15 = br_15.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter15++;
					if (strLine_15.equals(getfinalpath)) {
						if (paths.get(strLine_15)) {
							break;
						} else {
							paths.put(strLine_15, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_15);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_15, fin_45);

							if (!statu_15[counter15]) {

								for (int s = 0; s < R; s++) {

									solution_15[counter15][s] = x[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_15[counter15] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_15++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_15.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_16)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_16 = new File(location + "abbbb.txt");
				FileReader fileReader_16 = new FileReader(file_16);
				BufferedReader br_16 = new BufferedReader(fileReader_16);

				String strLine_16;

				int counter16 = -1;
				while ((strLine_16 = br_16.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter16++;
					if (strLine_16.equals(getfinalpath)) {

						if (paths.get(strLine_16)) {
							break;
						}

						else {
							paths.put(strLine_16, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_16);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_16, fin_46);

							if (!statu_16[counter16]) {

								for (int s = 0; s < R; s++) {

									solution_16[counter16][s] = x[i][s];

								}
								statu_16[counter16] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_16++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}

				}
				fileReader_16.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_17)) { // if the traversed path_id is equal to "the template
																// id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_17 = new File(location + "baaaa.txt");
				FileReader fileReader_17 = new FileReader(file_17);
				BufferedReader br_17 = new BufferedReader(fileReader_17);

				String strLine_17;

				int counter17 = -1;
				while ((strLine_17 = br_17.readLine()) != null) {
					// Print the paths in this group to the console
					// // (strLine);
					counter17++;

					if (strLine_17.equals(getfinalpath)) {

						if (paths.get(strLine_17)) {
							break;
						}

						else {
							paths.put(strLine_17, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_17);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_17, fin_31);

							if (!statu_17[counter17]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_17[counter17][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_17[counter17] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_17++;

								totalpathcounter++;

								break;
							}
						}
					}

				}
				fileReader_17.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_18)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_18 = new File(location + "baaab.txt");
				FileReader fileReader_18 = new FileReader(file_18);
				BufferedReader br_18 = new BufferedReader(fileReader_18);

				String strLine_18;
				// Read File Line By Line
				// int counter1 = -1;
				int counter18 = -1;
				while ((strLine_18 = br_18.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter18++;
					if (strLine_18.equals(getfinalpath)) {

						if (paths.get(strLine_18)) {
							break;
						} else {
							paths.put(strLine_18, true);

							int xxi = 0;
							int valz = pathcounter.get(template_18);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_18, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_18[counter18]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_18[counter18][s] = x[i][s];

								}
								statu_18[counter18] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_18++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_18.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_19)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_19 = new File(location + "baaba.txt");
				FileReader fileReader_19 = new FileReader(file_19);
				BufferedReader br_19 = new BufferedReader(fileReader_19);

				String strLine_19;
				// Read File Line By Line
				// int counter1 = -1;
				int counter19 = -1;
				while ((strLine_19 = br_19.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter19++;
					if (strLine_19.equals(getfinalpath)) {

						if (paths.get(strLine_19)) {
							break;
						} else {
							paths.put(strLine_19, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_19);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_19, fin_34);

							if (!statu_19[counter19]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_19[counter19][s] = x[i][s];

								}
								statu_19[counter19] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_19++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_19.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_20)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_20 = new File(location + "baabb.txt");
				FileReader fileReader_20 = new FileReader(file_20);
				BufferedReader br_20 = new BufferedReader(fileReader_20);

				String strLine_20;
				// Read File Line By Line
				// int counter1 = -1;
				int counter20 = -1;
				while ((strLine_20 = br_20.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter20++;
					if (strLine_20.equals(getfinalpath)) {
						if (paths.get(strLine_20)) {
							break;
						}

						else {
							paths.put(strLine_20, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_20);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_20, fin_35);

							if (!statu_20[counter20]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_20[counter20][s] = x[i][s];

								}
								statu_20[counter20] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_20++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_20.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_21)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_21 = new File(location + "babaa.txt");
				FileReader fileReader_21 = new FileReader(file_21);
				BufferedReader br_21 = new BufferedReader(fileReader_21);

				String strLine_21;
				// Read File Line By Line
				// int counter1 = -1;
				int counter21 = -1;
				while ((strLine_21 = br_21.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter21++;
					if (strLine_21.equals(getfinalpath)) {

						if (paths.get(strLine_21)) {
							break;
						} else {
							paths.put(strLine_21, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_21);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_21, fin_36);

							if (!statu_21[counter21]) {

								for (int s = 0; s < R; s++) {

									solution_21[counter21][s] = x[i][s];

								}
								statu_21[counter21] = true; //
								obj_21++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_21.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_22)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_22 = new File(location + "babab.txt");
				FileReader fileReader_22 = new FileReader(file_22);
				BufferedReader br_22 = new BufferedReader(fileReader_22);

				String strLine_22;
				// Read File Line By Line
				// int counter1 = -1;
				int counter22 = -1;
				while ((strLine_22 = br_22.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter22++;
					if (strLine_22.equals(getfinalpath)) {
						if (paths.get(strLine_22)) {
							break;
						}

						else {
							paths.put(strLine_22, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_22);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_22, fin_37);

							if (!statu_22[counter22]) {

								for (int s = 0; s < R; s++) {

									solution_22[counter22][s] = x[i][s];

								}
								statu_22[counter22] = true; //
								obj_22++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_22.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_23)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_23 = new File(location + "babba.txt");
				FileReader fileReader_23 = new FileReader(file_23);
				BufferedReader br_23 = new BufferedReader(fileReader_23);

				String strLine_23;
				// Read File Line By Line
				// int counter1 = -1;
				int counter23 = -1;
				while ((strLine_23 = br_23.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter23++;
					if (strLine_23.equals(getfinalpath)) {
						if (paths.get(strLine_23)) {
							break;
						}

						else {
							paths.put(strLine_23, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_23);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_23, fin_38);

							if (!statu_23[counter23]) {

								for (int s = 0; s < R; s++) {

									solution_23[counter23][s] = x[i][s];

								}
								statu_23[counter23] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_23++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_23.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_24)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_24 = new File(location + "babbb.txt");
				FileReader fileReader_24 = new FileReader(file_24);
				BufferedReader br_24 = new BufferedReader(fileReader_24);

				String strLine_24;
				// Read File Line By Line
				// int counter1 = -1;
				int counter24 = -1;
				while ((strLine_24 = br_24.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter24++;
					if (strLine_24.equals(getfinalpath)) {
						if (paths.get(strLine_24)) {
							break;
						} else {
							paths.put(strLine_24, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_24);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_24, fin_39);

							if (!statu_24[counter24]) {

								for (int s = 0; s < R; s++) {

									solution_24[counter24][s] = x[i][s];

								}
								statu_24[counter24] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_24++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_24.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_25)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_25 = new File(location + "bbaaa.txt");
				FileReader fileReader_25 = new FileReader(file_25);
				BufferedReader br_25 = new BufferedReader(fileReader_25);

				String strLine_25;
				// Read File Line By Line
				// int counter1 = -1;
				int counter25 = -1;
				while ((strLine_25 = br_25.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter25++;
					if (strLine_25.equals(getfinalpath)) {
						if (paths.get(strLine_25)) {
							break;
						} else {
							paths.put(strLine_25, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_25);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_25, fin_40);

							if (!statu_25[counter25]) {

								for (int s = 0; s < R; s++) {

									solution_25[counter25][s] = x[i][s];

								}
								statu_25[counter25] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_25++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_25.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_26)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_26 = new File(location + "bbaab.txt");
				FileReader fileReader_26 = new FileReader(file_26);
				BufferedReader br_26 = new BufferedReader(fileReader_26);

				String strLine_26;
				// Read File Line By Line
				// int counter1 = -1;
				int counter26 = -1;
				while ((strLine_26 = br_26.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter26++;
					if (strLine_26.equals(getfinalpath)) {
						if (paths.get(strLine_26)) {
							break;
						}

						else {
							paths.put(strLine_26, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_26);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_26, fin_41);

							if (!statu_26[counter26]) {

								for (int s = 0; s < R; s++) {

									solution_26[counter26][s] = x[i][s];

								}
								statu_26[counter26] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_26++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_26.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_27)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_27 = new File(location + "bbaba.txt");
				FileReader fileReader_27 = new FileReader(file_27);
				BufferedReader br_27 = new BufferedReader(fileReader_27);

				String strLine_27;
				// Read File Line By Line
				// int counter1 = -1;
				int counter27 = -1;
				while ((strLine_27 = br_27.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter27++;
					if (strLine_27.equals(getfinalpath)) {

						if (paths.get(strLine_27)) {
							break;
						} else {
							paths.put(strLine_27, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_27);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_27, fin_42);

							if (!statu_27[counter27]) {

								for (int s = 0; s < R; s++) {

									solution_27[counter27][s] = x[i][s];

								}
								statu_27[counter27] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_27++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_27.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_28)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_28 = new File(location + "bbabb.txt");
				FileReader fileReader_28 = new FileReader(file_28);
				BufferedReader br_28 = new BufferedReader(fileReader_28);

				String strLine_28;
				// Read File Line By Line
				// int counter1 = -1;
				int counter28 = -1;
				while ((strLine_28 = br_28.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter28++;
					if (strLine_28.equals(getfinalpath)) {
						if (paths.get(strLine_28)) {
							break;
						} else {
							paths.put(strLine_28, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_28);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_28, fin_43);

							if (!statu_28[counter28]) {

								for (int s = 0; s < R; s++) {

									solution_28[counter28][s] = x[i][s];

								}
								statu_28[counter28] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_28++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_28.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_29)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_29 = new File(location + "bbbaa.txt");
				FileReader fileReader_29 = new FileReader(file_29);
				BufferedReader br_29 = new BufferedReader(fileReader_29);

				String strLine_29;
				// Read File Line By Line
				// int counter1 = -1;
				int counter29 = -1;
				while ((strLine_29 = br_29.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter29++;
					if (strLine_29.equals(getfinalpath)) {
						if (paths.get(strLine_29)) {
							break;
						} else {
							paths.put(strLine_29, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_29);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_29, fin_44);

							if (!statu_29[counter29]) {

								for (int s = 0; s < R; s++) {

									solution_29[counter29][s] = x[i][s];

								}
								statu_29[counter29] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_29++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_29.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_30)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_30 = new File(location + "bbbab.txt");
				FileReader fileReader_30 = new FileReader(file_30);
				BufferedReader br_30 = new BufferedReader(fileReader_30);

				String strLine_30;
				// Read File Line By Line
				// int counter1 = -1;
				int counter30 = -1;
				while ((strLine_30 = br_30.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter30++;
					if (strLine_30.equals(getfinalpath)) {
						if (paths.get(strLine_30)) {
							break;
						}

						else {
							paths.put(strLine_30, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_30);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_30, fin_45);

							if (!statu_30[counter30]) {

								for (int s = 0; s < R; s++) {

									solution_30[counter30][s] = x[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_30[counter30] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_30++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_30.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_31)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_31 = new File(location + "bbbba.txt");
				FileReader fileReader_31 = new FileReader(file_31);
				BufferedReader br_31 = new BufferedReader(fileReader_31);

				String strLine_31;

				int counter31 = -1;
				while ((strLine_31 = br_31.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter31++;
					if (strLine_31.equals(getfinalpath)) {

						if (paths.get(strLine_31)) {
							break;
						}

						else {
							paths.put(strLine_31, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_31);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_31, fin_46);

							if (!statu_31[counter31]) {

								for (int s = 0; s < R; s++) {

									solution_31[counter31][s] = x[i][s];

								}
								statu_31[counter31] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_31++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_31.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_32)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_32 = new File(location + "bbbbb.txt");
				FileReader fileReader_32 = new FileReader(file_32);
				BufferedReader br_32 = new BufferedReader(fileReader_32);

				String strLine_32;

				int counter32 = -1;
				while ((strLine_32 = br_32.readLine()) != null) {
					// Print the paths in this group to the console
					// // (strLine);
					counter32++;

					if (strLine_32.equals(getfinalpath)) {

						if (paths.get(strLine_32)) {
							break;
						} else {
							paths.put(strLine_32, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_32);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_32, fin_31);

							if (!statu_32[counter32]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_32[counter32][s] = x[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_32[counter32] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_32++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_32.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}
	}

	public static void traverse_1(String getfinalpath, int i) {

		String final_path_checker = getfinalpath;

		if (final_path_checker.startsWith(template_1)) { // if the traversed path_id is equal to "the template id"

			try {

				// Open the file/template with that id that is the first
				// command line parameter
				File file_1 = new File(location + "aaaaa.txt");
				FileReader fileReader_1 = new FileReader(file_1);
				BufferedReader br_1 = new BufferedReader(fileReader_1);

				String strLine_1;

				int counter1 = -1;
				while ((strLine_1 = br_1.readLine()) != null) {
					// Print the paths in this group to the console
					// // (strLine);
					counter1++;

					if (strLine_1.equals(getfinalpath)) {

						if (paths.get(strLine_1)) {
							break;
						}

						else {
							paths.put(strLine_1, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_1);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_1, fin_31);

							if (!statu_1[counter1]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_1[counter1][s] = v[i][s];

								}
								statu_1[counter1] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_1++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_1.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_2)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_2 = new File(location + "aaaab.txt");
				FileReader fileReader_2 = new FileReader(file_2);
				BufferedReader br_2 = new BufferedReader(fileReader_2);

				String strLine_2;
				// Read File Line By Line

				int counter2 = -1;
				while ((strLine_2 = br_2.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter2++;
					if (strLine_2.equals(getfinalpath)) {

						if (paths.get(strLine_2)) {
							break;
						} else {
							paths.put(strLine_2, true);

							int g_32 = 0;
							int va_32 = pathcounter.get(template_2);

							g_32++;
							int fin_32 = va_32 + g_32;

							pathcounter.put(template_2, fin_32);

							// break;

							if (!statu_2[counter2]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_2[counter2][s] = v[i][s];

								}
								statu_2[counter2] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_2++;
								// pathcounter.put("1110", pathcounter.get("1110") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_2.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_3)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_3 = new File(location + "aaaba.txt");
				FileReader fileReader_3 = new FileReader(file_3);
				BufferedReader br_3 = new BufferedReader(fileReader_3);

				String strLine_3;
				// Read File Line By Line
				// int counter1 = -1;
				int counter3 = -1;
				while ((strLine_3 = br_3.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter3++;
					if (strLine_3.equals(getfinalpath)) {

						if (paths.get(strLine_3)) {
							break;
						}

						else {
							paths.put(strLine_3, true);

							int xxi = 0;
							int valz = pathcounter.get(template_3);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_3, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_3[counter3]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_3[counter3][s] = v[i][s];

								}
								statu_3[counter3] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_3++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_3.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_4)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_4 = new File(location + "aaabb.txt");
				FileReader fileReader_4 = new FileReader(file_4);
				BufferedReader br_4 = new BufferedReader(fileReader_4);

				String strLine_4;
				// Read File Line By Line
				// int counter1 = -1;
				int counter4 = -1;
				while ((strLine_4 = br_4.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter4++;
					if (strLine_4.equals(getfinalpath)) {

						if (paths.get(strLine_4)) {
							break;
						} else {
							paths.put(strLine_4, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_4);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_4, fin_34);

							if (!statu_4[counter4]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_4[counter4][s] = v[i][s];

								}
								statu_4[counter4] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_4++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_4.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_5)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_5 = new File(location + "aabaa.txt");
				FileReader fileReader_5 = new FileReader(file_5);
				BufferedReader br_5 = new BufferedReader(fileReader_5);

				String strLine_5;
				// Read File Line By Line
				// int counter1 = -1;
				int counter5 = -1;
				while ((strLine_5 = br_5.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter5++;
					if (strLine_5.equals(getfinalpath)) {
						if (paths.get(strLine_5)) {
							break;
						}

						else {
							paths.put(strLine_5, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_5);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_5, fin_35);

							if (!statu_5[counter5]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_5[counter5][s] = v[i][s];

								}
								statu_5[counter5] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_5++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_5.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_6)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_6 = new File(location + "aabab.txt");
				FileReader fileReader_6 = new FileReader(file_6);
				BufferedReader br_6 = new BufferedReader(fileReader_6);

				String strLine_6;
				// Read File Line By Line
				// int counter1 = -1;
				int counter6 = -1;
				while ((strLine_6 = br_6.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter6++;
					if (strLine_6.equals(getfinalpath)) {

						if (paths.get(strLine_6)) {
							break;
						} else {
							paths.put(strLine_6, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_6);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_6, fin_36);

							if (!statu_6[counter6]) {

								for (int s = 0; s < R; s++) {

									solution_6[counter6][s] = v[i][s];

								}
								statu_6[counter6] = true; //
								obj_6++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_6.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_7)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_7 = new File(location + "aabba.txt");
				FileReader fileReader_7 = new FileReader(file_7);
				BufferedReader br_7 = new BufferedReader(fileReader_7);

				String strLine_7;
				// Read File Line By Line
				// int counter1 = -1;
				int counter7 = -1;
				while ((strLine_7 = br_7.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter7++;
					if (strLine_7.equals(getfinalpath)) {
						if (paths.get(strLine_7)) {
							break;
						}

						else {
							paths.put(strLine_7, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_7);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_7, fin_37);

							if (!statu_7[counter7]) {

								for (int s = 0; s < R; s++) {

									solution_7[counter7][s] = v[i][s];

								}
								statu_7[counter7] = true; //
								obj_7++;
								totalpathcounter++;

								break;
							}
						}
					}

				}
				fileReader_7.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_8)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_8 = new File(location + "aabbb.txt");
				FileReader fileReader_8 = new FileReader(file_8);
				BufferedReader br_8 = new BufferedReader(fileReader_8);

				String strLine_8;
				// Read File Line By Line
				// int counter1 = -1;
				int counter8 = -1;
				while ((strLine_8 = br_8.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter8++;
					if (strLine_8.equals(getfinalpath)) {
						if (paths.get(strLine_8)) {
							break;
						} else {
							paths.put(strLine_8, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_8);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_8, fin_38);

							if (!statu_8[counter8]) {

								for (int s = 0; s < R; s++) {

									solution_8[counter8][s] = v[i][s];

								}
								statu_8[counter8] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_8++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_8.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_9)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_9 = new File(location + "abaaa.txt");
				FileReader fileReader_9 = new FileReader(file_9);
				BufferedReader br_9 = new BufferedReader(fileReader_9);

				String strLine_9;
				// Read File Line By Line
				// int counter1 = -1;
				int counter9 = -1;
				while ((strLine_9 = br_9.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter9++;
					if (strLine_9.equals(getfinalpath)) {
						if (paths.get(strLine_9)) {
							break;
						}

						else {
							paths.put(strLine_9, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_9);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_9, fin_39);

							if (!statu_9[counter9]) {

								for (int s = 0; s < R; s++) {

									solution_9[counter9][s] = v[i][s];

								}
								statu_9[counter9] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_9++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_9.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_10)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_10 = new File(location + "abaab.txt");
				FileReader fileReader_10 = new FileReader(file_10);
				BufferedReader br_10 = new BufferedReader(fileReader_10);

				String strLine_10;
				// Read File Line By Line
				// int counter1 = -1;
				int counter10 = -1;
				while ((strLine_10 = br_10.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter10++;
					if (strLine_10.equals(getfinalpath)) {
						if (paths.get(strLine_10)) {
							break;
						}

						else {
							paths.put(strLine_10, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_10);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_10, fin_40);

							if (!statu_10[counter10]) {

								for (int s = 0; s < R; s++) {

									solution_10[counter10][s] = v[i][s];

								}
								statu_10[counter10] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_10++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_10.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_11)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_11 = new File(location + "ababa.txt");
				FileReader fileReader_11 = new FileReader(file_11);
				BufferedReader br_11 = new BufferedReader(fileReader_11);

				String strLine_11;
				// Read File Line By Line
				// int counter1 = -1;
				int counter11 = -1;
				while ((strLine_11 = br_11.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter11++;
					if (strLine_11.equals(getfinalpath)) {
						if (paths.get(strLine_11)) {
							break;
						} else {
							paths.put(strLine_11, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_11);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_11, fin_41);

							if (!statu_11[counter11]) {

								for (int s = 0; s < R; s++) {

									solution_11[counter11][s] = v[i][s];

								}
								statu_11[counter11] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_11++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_11.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_12)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_12 = new File(location + "ababb.txt");
				FileReader fileReader_12 = new FileReader(file_12);
				BufferedReader br_12 = new BufferedReader(fileReader_12);

				String strLine_12;
				// Read File Line By Line
				// int counter1 = -1;
				int counter12 = -1;
				while ((strLine_12 = br_12.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter12++;
					if (strLine_12.equals(getfinalpath)) {

						if (paths.get(strLine_12)) {
							break;
						} else {
							paths.put(strLine_12, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_12);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_12, fin_42);

							if (!statu_12[counter12]) {

								for (int s = 0; s < R; s++) {

									solution_12[counter12][s] = v[i][s];

								}
								statu_12[counter12] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_12++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}

				}
				fileReader_12.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_13)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_13 = new File(location + "abbaa.txt");
				FileReader fileReader_13 = new FileReader(file_13);
				BufferedReader br_13 = new BufferedReader(fileReader_13);

				String strLine_13;
				// Read File Line By Line
				// int counter1 = -1;
				int counter13 = -1;
				while ((strLine_13 = br_13.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter13++;
					if (strLine_13.equals(getfinalpath)) {
						if (paths.get(strLine_13)) {
							break;
						} else {
							paths.put(strLine_13, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_13);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_13, fin_43);

							if (!statu_13[counter13]) {

								for (int s = 0; s < R; s++) {

									solution_13[counter13][s] = v[i][s];

								}
								statu_13[counter13] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_13++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_13.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_14)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_14 = new File(location + "abbab.txt");
				FileReader fileReader_14 = new FileReader(file_14);
				BufferedReader br_14 = new BufferedReader(fileReader_14);

				String strLine_14;
				// Read File Line By Line
				// int counter1 = -1;
				int counter14 = -1;
				while ((strLine_14 = br_14.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter14++;
					if (strLine_14.equals(getfinalpath)) {
						if (paths.get(strLine_14)) {
							break;
						} else {
							paths.put(strLine_14, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_14);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_14, fin_44);

							if (!statu_14[counter14]) {

								for (int s = 0; s < R; s++) {

									solution_14[counter14][s] = v[i][s];

								}
								statu_14[counter14] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_14++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_14.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_15)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_15 = new File(location + "abbba.txt");
				FileReader fileReader_15 = new FileReader(file_15);
				BufferedReader br_15 = new BufferedReader(fileReader_15);

				String strLine_15;
				// Read File Line By Line
				// int counter1 = -1;
				int counter15 = -1;
				while ((strLine_15 = br_15.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter15++;
					if (strLine_15.equals(getfinalpath)) {
						if (paths.get(strLine_15)) {
							break;
						} else {
							paths.put(strLine_15, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_15);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_15, fin_45);

							if (!statu_15[counter15]) {

								for (int s = 0; s < R; s++) {

									solution_15[counter15][s] = v[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_15[counter15] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_15++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_15.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_16)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_16 = new File(location + "abbbb.txt");
				FileReader fileReader_16 = new FileReader(file_16);
				BufferedReader br_16 = new BufferedReader(fileReader_16);

				String strLine_16;

				int counter16 = -1;
				while ((strLine_16 = br_16.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter16++;
					if (strLine_16.equals(getfinalpath)) {

						if (paths.get(strLine_16)) {
							break;
						}

						else {
							paths.put(strLine_16, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_16);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_16, fin_46);

							if (!statu_16[counter16]) {

								for (int s = 0; s < R; s++) {

									solution_16[counter16][s] = v[i][s];

								}
								statu_16[counter16] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_16++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}

				}
				fileReader_16.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_17)) { // if the traversed path_id is equal to "the template
																// id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_17 = new File(location + "baaaa.txt");
				FileReader fileReader_17 = new FileReader(file_17);
				BufferedReader br_17 = new BufferedReader(fileReader_17);

				String strLine_17;

				int counter17 = -1;
				while ((strLine_17 = br_17.readLine()) != null) {
					// Print the paths in this group to the console
					// // (strLine);
					counter17++;

					if (strLine_17.equals(getfinalpath)) {

						if (paths.get(strLine_17)) {
							break;
						}

						else {
							paths.put(strLine_17, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_17);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_17, fin_31);

							if (!statu_17[counter17]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_17[counter17][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_17[counter17] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_17++;

								totalpathcounter++;

								break;
							}
						}
					}

				}
				fileReader_17.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_18)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_18 = new File(location + "baaab.txt");
				FileReader fileReader_18 = new FileReader(file_18);
				BufferedReader br_18 = new BufferedReader(fileReader_18);

				String strLine_18;
				// Read File Line By Line
				// int counter1 = -1;
				int counter18 = -1;
				while ((strLine_18 = br_18.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter18++;
					if (strLine_18.equals(getfinalpath)) {

						if (paths.get(strLine_18)) {
							break;
						} else {
							paths.put(strLine_18, true);

							int xxi = 0;
							int valz = pathcounter.get(template_18);

							xxi++;
							int fin = valz + xxi;

							pathcounter.put(template_18, fin);
							// call path status .. assign truth flag... along that path...

							if (!statu_18[counter18]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_18[counter18][s] = v[i][s];

								}
								statu_18[counter18] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_18++;
								// pathcounter.put("1101", pathcounter.get("1101") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}

				fileReader_18.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_19)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_19 = new File(location + "baaba.txt");
				FileReader fileReader_19 = new FileReader(file_19);
				BufferedReader br_19 = new BufferedReader(fileReader_19);

				String strLine_19;
				// Read File Line By Line
				// int counter1 = -1;
				int counter19 = -1;
				while ((strLine_19 = br_19.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter19++;
					if (strLine_19.equals(getfinalpath)) {

						if (paths.get(strLine_19)) {
							break;
						} else {
							paths.put(strLine_19, true);

							int g_34 = 0;
							int va_34 = pathcounter.get(template_19);

							g_34++;
							int fin_34 = va_34 + g_34;

							pathcounter.put(template_19, fin_34);

							if (!statu_19[counter19]) {
								// array template_1path_id

								for (int s = 0; s < R; s++) {

									solution_19[counter19][s] = v[i][s];

								}
								statu_19[counter19] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_19++;
								// pathcounter.put("1100", pathcounter.get("1100") + 1);
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_19.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_20)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_20 = new File(location + "baabb.txt");
				FileReader fileReader_20 = new FileReader(file_20);
				BufferedReader br_20 = new BufferedReader(fileReader_20);

				String strLine_20;
				// Read File Line By Line
				// int counter1 = -1;
				int counter20 = -1;
				while ((strLine_20 = br_20.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter20++;
					if (strLine_20.equals(getfinalpath)) {
						if (paths.get(strLine_20)) {
							break;
						}

						else {
							paths.put(strLine_20, true);

							int g_35 = 0;
							int va_35 = pathcounter.get(template_20);

							g_35++;
							int fin_35 = va_35 + g_35;

							pathcounter.put(template_20, fin_35);

							if (!statu_20[counter20]) {
								// array template_1path_id

								// pathcounter.put("1011", pathcounter.get("1011") + 1);

								for (int s = 0; s < R; s++) {

									solution_20[counter20][s] = v[i][s];

								}
								statu_20[counter20] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_20++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_20.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if( totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break
		// out of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_21)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_21 = new File(location + "babaa.txt");
				FileReader fileReader_21 = new FileReader(file_21);
				BufferedReader br_21 = new BufferedReader(fileReader_21);

				String strLine_21;
				// Read File Line By Line
				// int counter1 = -1;
				int counter21 = -1;
				while ((strLine_21 = br_21.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter21++;
					if (strLine_21.equals(getfinalpath)) {

						if (paths.get(strLine_21)) {
							break;
						} else {
							paths.put(strLine_21, true);

							int g_36 = 0;
							int va_36 = pathcounter.get(template_21);

							g_36++;
							int fin_36 = va_36 + g_36;

							pathcounter.put(template_21, fin_36);

							if (!statu_21[counter21]) {

								for (int s = 0; s < R; s++) {

									solution_21[counter21][s] = v[i][s];

								}
								statu_21[counter21] = true; //
								obj_21++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_21.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_22)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_22 = new File(location + "babab.txt");
				FileReader fileReader_22 = new FileReader(file_22);
				BufferedReader br_22 = new BufferedReader(fileReader_22);

				String strLine_22;
				// Read File Line By Line
				// int counter1 = -1;
				int counter22 = -1;
				while ((strLine_22 = br_22.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter22++;
					if (strLine_22.equals(getfinalpath)) {
						if (paths.get(strLine_22)) {
							break;
						}

						else {
							paths.put(strLine_22, true);

							int g_37 = 0;
							int va_37 = pathcounter.get(template_22);

							g_37++;
							int fin_37 = va_37 + g_37;

							pathcounter.put(template_22, fin_37);

							if (!statu_22[counter22]) {

								for (int s = 0; s < R; s++) {

									solution_22[counter22][s] = v[i][s];

								}
								statu_22[counter22] = true; //
								obj_22++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_22.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_23)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_23 = new File(location + "babba.txt");
				FileReader fileReader_23 = new FileReader(file_23);
				BufferedReader br_23 = new BufferedReader(fileReader_23);

				String strLine_23;
				// Read File Line By Line
				// int counter1 = -1;
				int counter23 = -1;
				while ((strLine_23 = br_23.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter23++;
					if (strLine_23.equals(getfinalpath)) {
						if (paths.get(strLine_23)) {
							break;
						}

						else {
							paths.put(strLine_23, true);

							int g_38 = 0;
							int va_38 = pathcounter.get(template_23);

							g_38++;
							int fin_38 = va_38 + g_38;

							pathcounter.put(template_23, fin_38);

							if (!statu_23[counter23]) {

								for (int s = 0; s < R; s++) {

									solution_23[counter23][s] = v[i][s];

								}
								statu_23[counter23] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_23++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_23.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_24)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_24 = new File(location + "babbb.txt");
				FileReader fileReader_24 = new FileReader(file_24);
				BufferedReader br_24 = new BufferedReader(fileReader_24);

				String strLine_24;
				// Read File Line By Line
				// int counter1 = -1;
				int counter24 = -1;
				while ((strLine_24 = br_24.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter24++;
					if (strLine_24.equals(getfinalpath)) {
						if (paths.get(strLine_24)) {
							break;
						} else {
							paths.put(strLine_24, true);

							int g_39 = 0;
							int va_39 = pathcounter.get(template_24);

							g_39++;
							int fin_39 = va_39 + g_39;

							pathcounter.put(template_24, fin_39);

							if (!statu_24[counter24]) {

								for (int s = 0; s < R; s++) {

									solution_24[counter24][s] = v[i][s];

								}
								statu_24[counter24] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_24++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_24.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_25)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_25 = new File(location + "bbaaa.txt");
				FileReader fileReader_25 = new FileReader(file_25);
				BufferedReader br_25 = new BufferedReader(fileReader_25);

				String strLine_25;
				// Read File Line By Line
				// int counter1 = -1;
				int counter25 = -1;
				while ((strLine_25 = br_25.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter25++;
					if (strLine_25.equals(getfinalpath)) {
						if (paths.get(strLine_25)) {
							break;
						} else {
							paths.put(strLine_25, true);
							int g_40 = 0;
							int va_40 = pathcounter.get(template_25);

							g_40++;
							int fin_40 = va_40 + g_40;

							pathcounter.put(template_25, fin_40);

							if (!statu_25[counter25]) {

								for (int s = 0; s < R; s++) {

									solution_25[counter25][s] = v[i][s];

								}
								statu_25[counter25] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_25++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_25.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_26)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_26 = new File(location + "bbaab.txt");
				FileReader fileReader_26 = new FileReader(file_26);
				BufferedReader br_26 = new BufferedReader(fileReader_26);

				String strLine_26;
				// Read File Line By Line
				// int counter1 = -1;
				int counter26 = -1;
				while ((strLine_26 = br_26.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter26++;
					if (strLine_26.equals(getfinalpath)) {
						if (paths.get(strLine_26)) {
							break;
						}

						else {
							paths.put(strLine_26, true);

							int g_41 = 0;
							int va_41 = pathcounter.get(template_26);

							g_41++;
							int fin_41 = va_41 + g_41;

							pathcounter.put(template_26, fin_41);

							if (!statu_26[counter26]) {

								for (int s = 0; s < R; s++) {

									solution_26[counter26][s] = v[i][s];

								}
								statu_26[counter26] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_26++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_26.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_27)) { // if the traversed path_id is equal to "the template
																// id"
																// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_27 = new File(location + "bbaba.txt");
				FileReader fileReader_27 = new FileReader(file_27);
				BufferedReader br_27 = new BufferedReader(fileReader_27);

				String strLine_27;
				// Read File Line By Line
				// int counter1 = -1;
				int counter27 = -1;
				while ((strLine_27 = br_27.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter27++;
					if (strLine_27.equals(getfinalpath)) {

						if (paths.get(strLine_27)) {
							break;
						} else {
							paths.put(strLine_27, true);

							int g_42 = 0;
							int va_42 = pathcounter.get(template_27);

							g_42++;
							int fin_42 = va_42 + g_42;

							pathcounter.put(template_27, fin_42);

							if (!statu_27[counter27]) {

								for (int s = 0; s < R; s++) {

									solution_27[counter27][s] = v[i][s];

								}
								statu_27[counter27] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_27++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_27.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_28)) { // if the traversed path_id is equal to "the template
																// id"
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_28 = new File(location + "bbabb.txt");
				FileReader fileReader_28 = new FileReader(file_28);
				BufferedReader br_28 = new BufferedReader(fileReader_28);

				String strLine_28;
				// Read File Line By Line
				// int counter1 = -1;
				int counter28 = -1;
				while ((strLine_28 = br_28.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter28++;
					if (strLine_28.equals(getfinalpath)) {
						if (paths.get(strLine_28)) {
							break;
						} else {
							paths.put(strLine_28, true);

							int g_43 = 0;
							int va_43 = pathcounter.get(template_28);

							g_43++;
							int fin_43 = va_43 + g_43;

							pathcounter.put(template_28, fin_43);

							if (!statu_28[counter28]) {

								for (int s = 0; s < R; s++) {

									solution_28[counter28][s] = v[i][s];

								}
								statu_28[counter28] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_28++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_28.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_29)) { // if the traversed path_id is equal to "the template
																// id"

			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_29 = new File(location + "bbbaa.txt");
				FileReader fileReader_29 = new FileReader(file_29);
				BufferedReader br_29 = new BufferedReader(fileReader_29);

				String strLine_29;
				// Read File Line By Line
				// int counter1 = -1;
				int counter29 = -1;
				while ((strLine_29 = br_29.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter29++;
					if (strLine_29.equals(getfinalpath)) {
						if (paths.get(strLine_29)) {
							break;
						} else {
							paths.put(strLine_29, true);

							int g_44 = 0;
							int va_44 = pathcounter.get(template_29);

							g_44++;
							int fin_44 = va_44 + g_44;

							pathcounter.put(template_29, fin_44);

							if (!statu_29[counter29]) {

								for (int s = 0; s < R; s++) {

									solution_29[counter29][s] = v[i][s];

								}
								statu_29[counter29] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_29++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_29.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		// if(totalpathcounter ==TOTAL_PATHNUM ) { // if all paths are covered break out
		// of the loop
		// break ;
		// }

		else if (final_path_checker.startsWith(template_30)) { // if the traversed path_id is equal to "the template
																// id"
			// ******
			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_30 = new File(location + "bbbab.txt");
				FileReader fileReader_30 = new FileReader(file_30);
				BufferedReader br_30 = new BufferedReader(fileReader_30);

				String strLine_30;
				// Read File Line By Line
				// int counter1 = -1;
				int counter30 = -1;
				while ((strLine_30 = br_30.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter30++;
					if (strLine_30.equals(getfinalpath)) {
						if (paths.get(strLine_30)) {
							break;
						}

						else {
							paths.put(strLine_30, true);

							int g_45 = 0;
							int va_45 = pathcounter.get(template_30);

							g_45++;
							int fin_45 = va_45 + g_45;

							pathcounter.put(template_30, fin_45);

							if (!statu_30[counter30]) {

								for (int s = 0; s < R; s++) {

									solution_30[counter30][s] = v[i][s]; // only for this template

									// solution of the main file of maps

								}
								statu_30[counter30] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_30++;
								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_30.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		else if (final_path_checker.startsWith(template_31)) { // if the traversed path_id is equal to "the template
																// id"
																// ******

			// **************************************************************************//
			try {
				// Open the file/template with that id that is the first
				// command line parameter

				File file_31 = new File(location + "bbbba.txt");
				FileReader fileReader_31 = new FileReader(file_31);
				BufferedReader br_31 = new BufferedReader(fileReader_31);

				String strLine_31;

				int counter31 = -1;
				while ((strLine_31 = br_31.readLine()) != null) {
					// Print the content on the console
					// // (strLine);
					counter31++;
					if (strLine_31.equals(getfinalpath)) {

						if (paths.get(strLine_31)) {
							break;
						}

						else {
							paths.put(strLine_31, true);

							int g_46 = 0;
							int va_46 = pathcounter.get(template_31);

							g_46++;
							int fin_46 = va_46 + g_46;

							pathcounter.put(template_31, fin_46);

							if (!statu_31[counter31]) {

								for (int s = 0; s < R; s++) {

									solution_31[counter31][s] = v[i][s];

								}
								statu_31[counter31] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_31++;
								totalpathcounter++;
								// get other nodes(not part of the simple loop pattern)

								break;
							}
						}
					}
				}
				fileReader_31.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}

		if (final_path_checker.startsWith(template_32)) { // if the traversed path_id is equal to "the template id"

			try {
				// Open the file/template with that id that is the first
				// command line parameter
				File file_32 = new File(location + "bbbbb.txt");
				FileReader fileReader_32 = new FileReader(file_32);
				BufferedReader br_32 = new BufferedReader(fileReader_32);

				String strLine_32;

				int counter32 = -1;
				while ((strLine_32 = br_32.readLine()) != null) {
					// Print the paths in this group to the console
					// // (strLine);
					counter32++;

					if (strLine_32.equals(getfinalpath)) {

						if (paths.get(strLine_32)) {
							break;
						} else {
							paths.put(strLine_32, true);

							int g_31 = 0;
							int va_31 = pathcounter.get(template_32);

							g_31++;
							int fin_31 = va_31 + g_31;

							pathcounter.put(template_32, fin_31);

							if (!statu_32[counter32]) { // this status array keeps track of the index of the path in
														// the file..o
								// to establish if it's covered or not

								for (int s = 0; s < R; s++) {

									solution_32[counter32][s] = v[i][s];
									// capture solution for main file
									// old_1[counter1][s]= x[i][s];
									// check if map contains this with false visit it contains

								}
								statu_32[counter32] = true; // ���·��Path�Ƿ����ҵ�������������
								obj_32++;

								totalpathcounter++;

								break;
							}
						}
					}
				}
				fileReader_32.close(); // Close the input stream

			} catch (Exception e) {
			}
			// }

		}
	}

	static float getAverages(float[] array, int num) {
		float sum = 0;
		for (int i = 0; i < num; i++) {
			sum += array[i];
		}
		return (float) (sum / num);
	}

}
