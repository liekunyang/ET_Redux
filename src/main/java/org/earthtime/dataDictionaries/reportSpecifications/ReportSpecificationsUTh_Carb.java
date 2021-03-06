/*
 * ReportSpecificationsUTh_Carb.java
 *
 * Copyright 2006-2017 James F. Bowring and www.Earth-Time.org
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.earthtime.dataDictionaries.reportSpecifications;

import java.util.HashMap;
import java.util.Map;
import org.earthtime.dataDictionaries.RadDates;
import org.earthtime.dataDictionaries.UThAnalysisMeasures;
import org.earthtime.dataDictionaries.UThCompositionalMeasures;
import org.earthtime.dataDictionaries.UThFractionationCorrectedIsotopicRatios;

/**
 *
 * @author James F. Bowring
 */
public class ReportSpecificationsUTh_Carb extends ReportSpecificationsAbstract {

    // Report column order =
    //  displayName1, displayName2, displayName3, units, retrieveMethodName, retrieveParameterName, uncertaintyType,
    //     footnoteSpec, visible, useArbitrary? for value, digitcount value, unct visible (if required), description where needed,
    //     needsLead, needsUranium
    // details: https://docs.google.com/spreadsheets/d/1w15Nc4uD2WEg_e5KvAsNJrBaIImTPPTM8f33NaKkw34/edit#gid=0
    /**
     *
     */
    public static final String[][] ReportCategory_USeriesReportTable = new String[][]{
        {"", "uncorrected", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.date.getName(), "ABS",
            "FN-6", "true", "false", "2", "true", "Date", "false", "false"
        },
        {" BP", "uncorrected", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.dateBP.getName(), "ABS",
            "FN-7", "false", "false", "2", "true", "Date BP", "false", "false"
        },
        {"", "corrected", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.dateCorr.getName(), "ABS",
            "", "false", "false", "2", "true", "Date (detrital Th-corr.)", "false", "false"
        },
        {" BP", "corrected", "Date", "ka", "getRadiogenicIsotopeDateByName", RadDates.dateCorrBP.getName(), "ABS",
            "", "false", "false", "2", "true", "Date BP (detrital Th-corr.)", "false", "false"
        },
        //
        {"uncorrected", "delta234U", "initial", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234Ui.getName(), "ABS",
            "", "true", "false", "3", "true", "initial delta234U", "false", "false"
        },
        {"uncorrected", "[234U/", " 238U]initial", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Ui.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "initial [234U/238U]", "false", "false"
        },
        {"uncorrected", "234U/", "238U initial", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Ui.getName(), "ABS",
            "", "false", "false", "3", "true", "initial 234U/238U", "false", "false"
        },
        //
        {"corrected", "delta234U", "initial", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234Uidc.getName(), "ABS",
            "FN-4", "false", "false", "3", "true", "initial delta234U (detrital Th-corr.)", "false", "false"
        },
        {"corrected", "[234U/", " 238U]initial", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Uidc.getName(), "ABS",
            "FN-1&FN-4", "false", "false", "3", "true", "initial [234U/238U] (detrital Th-corr.)", "false", "false"
        },
        {"corrected", "234U/", "238U initial", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Uidc.getName(), "ABS",
            "FN-4", "false", "false", "3", "true", "initial 234U/238U (detrital Th-corr.)", "false", "false"
        },
        //
        {"rho", "date", "delta234U", "", "getAnalysisMeasure", UThAnalysisMeasures.rhoDate__delta234Ui.getName(), "",
            "", "false", "true", "3", "", "Corr. Coef. date - delta234Ui", "false", "false"
        }
    };

    // Report column order =
    //  displayName1, displayName2, displayName3, units, retrieveMethodName, retrieveParameterName, uncertaintyType,
    //     footnoteSpec, visible, useArbitrary? for value, digitcount value, unct visible (if required), description where needed,
    //     needsLead, needsUranium
    // details: https://docs.google.com/spreadsheets/d/1w15Nc4uD2WEg_e5KvAsNJrBaIImTPPTM8f33NaKkw34/edit#gid=0
    /**
     *
     */
    public static final String[][] ReportCategory_USeriesConcentrationActivity = new String[][]{
        //        {"", "", "IGSN", "", "getCompositionalMeasureByName", UThCompositionalMeasures.conc238U.getName(), "ABS",
        //            "", "true", "true", "3", "", "238U concentration", "false", "false"
        //        },
        {"", "238U", "", "ppm", "getCompositionalMeasureByName", UThCompositionalMeasures.conc238U.getName(), "ABS",
            "", "true", "true", "3", "true", "238U concentration", "false", "false"
        },
        {"", "[238U]", "", "dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc238U.getName(), "ABS",
            "FN-1", "false", "true", "3", "true", "238U concentration activity", "false", "false"
        },
        //
        {"", "230Th", "", "ppt", "getCompositionalMeasureByName", UThCompositionalMeasures.conc230Th.getName(), "ABS",
            "", "true", "false", "3", "true", "230Th concentration", "false", "false"
        },
        {"", "[230Th]", "", "*1e9 dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc230Th.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "230Th concentration activity", "false", "false"
        },
        //
        {"", "232Th", "", "ppb", "getCompositionalMeasureByName", UThCompositionalMeasures.conc232Th.getName(), "ABS",
            "", "true", "true", "3", "true", "232Th concentration", "false", "false"
        },
        {"", "[232Th]", "", "*1e3 dpm/g", "getCompositionalMeasureByName", UThCompositionalMeasures.arConc232Th.getName(), "ABS",
            "FN-1", "false", "true", "3", "true", "232Th concentration activity", "false", "false"
        },};

    // Report column order =
    //  displayName1, displayName2, displayName3, units, retrieveMethodName, retrieveParameterName, uncertaintyType,
    //     footnoteSpec, visible, useArbitrary? for value, digitcount value, unct visible (if required), description where needed,
    //     needsLead, needsUranium
    // details: https://docs.google.com/spreadsheets/d/1w15Nc4uD2WEg_e5KvAsNJrBaIImTPPTM8f33NaKkw34/edit#gid=0
    /**
     *
     */
    public static final String[][] ReportCategory_USeriesMeasuredAtomAndActivityRatios = new String[][]{
        {"", "[230Th/", " 232Th]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar230Th_232Thfc.getName(), "ABS",
            "FN-1", "true", "false", "3", "true", "[230Th/232Th]", "false", "false"
        },
        {"", "230Th/", "232Th", "", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r230Th_232Thfc.getName(), "ABS",
            "", "false", "false", "3", "true", "230Th/232Th", "false", "false"
        },
        //
        {"[232Th/", " 238U]", "", "*1e5", "getAnalysisMeasure", UThAnalysisMeasures.ar232Th_238Ufc.getName(), "ABS",
            "FN-1", "false", "false", "3", "true", "[232Th/238U]", "false", "false"
        },
        {"232Th/", "238U", "", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r232Th_238Ufc.getName(), "ABS",
            "", "false", "false", "3", "true", "232Th/238U", "false", "false"
        },
        //
        {"uncorrected", "[230Th/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar230Th_238Ufc.getName(), "ABS",
            "FN-1&FN-2", "true", "false", "3", "true", "[230Th/238U]", "false", "false"
        },
        {"uncorrected", "230Th/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r230Th_238Ufc.getName(), "ABS",
            "FN-2", "false", "false", "3", "true", "230Th/238U", "false", "false"
        },
        //
        {"uncorrected", "", "delta234U", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234U.getName(), "ABS",
            "FN-3", "false", "false", "3", "true", "delta234U", "false", "false"
        },
        {"uncorrected", "[234U/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Ufc.getName(), "ABS",
            "FN-1&FN-3", "true", "false", "3", "true", "[234U/238U]", "false", "false"
        },
        {"uncorrected", "234U/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Ufc.getName(), "ABS",
            "FN-3", "false", "false", "3", "true", "234U/238U", "false", "false"
        },};

    // Report column order =
    //  displayName1, displayName2, displayName3, units, retrieveMethodName, retrieveParameterName, uncertaintyType,
    //     footnoteSpec, visible, useArbitrary? for value, digitcount value, unct visible (if required), description where needed,
    //     needsLead, needsUranium
    // details: https://docs.google.com/spreadsheets/d/1w15Nc4uD2WEg_e5KvAsNJrBaIImTPPTM8f33NaKkw34/edit#gid=0
    /**
     *
     */
    public static final String[][] ReportCategory_USeriesMeasuredDetritalCorrectedAtomAndActivityRatios = new String[][]{
        {"corrected", "[230Th/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar230Th_238Udc.getName(), "ABS",
            "FN-1&FN-2&FN-4", "false", "false", "3", "true", "[230Th/238U] (detrital Th-corr.)", "false", "false"
        },
        {"corrected", "230Th/", "238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r230Th_238Udc.getName(), "ABS",
            "FN-2&FN-4", "false", "false", "3", "true", "230Th/238U (detrital Th-corr.)", "false", "false"
        },
        //
        {"corrected", "", "delta234U", "", "getAnalysisMeasure", UThAnalysisMeasures.delta234Udc.getName(), "ABS",
            "FN-5", "false", "false", "3", "true", "delta234U (detrital Th-corr.)", "false", "false"
        },
        {"corrected", "[234U/", " 238U]", "", "getAnalysisMeasure", UThAnalysisMeasures.ar234U_238Udc.getName(), "ABS",
            "FN-1&FN-4", "false", "false", "3", "true", "[234U/238U] (detrital Th-corr.)", "false", "false"
        },
        {"corrected", "234U/", " 238U", "*1e5", "getRadiogenicIsotopeRatioByName", UThFractionationCorrectedIsotopicRatios.r234U_238Udc.getName(), "ABS",
            "FN-4", "false", "false", "3", "true", "234U/238U (detrital Th-corr.)", "false", "false"
        },};

    /**
     *
     */
    public final static Map<String, String> reportTableFootnotes = new HashMap<String, String>();

    static {

        reportTableFootnotes.put(//
                "FN-1", //
                "Square brackets denote activities or activity ratios.");
        reportTableFootnotes.put(//
                "FN-2", //
                "Ratio determined using a Th-U spike calibrated to a <secularOrGravimetric230238><named230Th238Umodel>");
        reportTableFootnotes.put(//
                "FN-3", //
                "Ratio calibrated to a <secularOrGravimetric234238><named234U238Umodel>");
        reportTableFootnotes.put(//
                "FN-4", //
                "Corrected for detrital Th assuming an initial [232Th/238U]= 1.2 ± 0.6, [234U/238U]= 1.0 ± 0.5,\nand [230Th/238U]= 1.0 ± 0.5");
        reportTableFootnotes.put(//
                "FN-5", //
                "\u03B4234Uinitial is corrected for radiogenic ingrowth and decay based on the detrital-corrected 230Th date\nand the detrital initial 234U. Ages do not include uncertainties associated with the decay constants.");
        reportTableFootnotes.put(//
                "FN-6", //
                "Uncorrected, closed-system date calculated using the decay constants <lambda230>,\n<lambda234>, and <lambda238>.\nDates reported relative to"
                + " the date of analysis, <dateOfAnalysis>,\nand do not include uncertainties associated with decay constants.");
        reportTableFootnotes.put(//
                "FN-7", //
                "Uncorrected, closed-system date calculated using the decay constants <lambda230>,\n<lambda234>, and <lambda238>.\nDates reported as Before Present (BP),"
                + " where Present is the year 1950 CE.,\nand do not include uncertainties associated with decay constants.");

    }
}
