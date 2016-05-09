/*
 * Copyright 2006-2016 CIRDLES.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.earthtime.Tripoli.rawDataFiles.handlers.shrimp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author James F. Bowring <bowring at gmail.com>
 */
public class ShrimpFraction implements Serializable {

    private String fractionID;
    private int spotNumber;
    private long dateTimeMilliseconds;
    private int deadTimeNanoseconds;
    private int sbmZeroCps;
    private double[] countTimeSec;
    private Map<RawRatioNamesSHRIMP, IsotopeRatioModelSHRIMP> isotopicRatios;
    private int[][] rawPeakData;
    private int[][] rawSBMData;
    private double[][] extractedRunData;
    private double[][] totalCounts;
    private  double[][] totalCountsOneSigmaAbs;
    private  double[][] totalCountsSBM;
    private double[][] timeStampSec;
    private  double [][] trimMass;
    private double[] totalCps;
    private double[][] netPkCps;
    private double[][] pkFerr;
    private boolean referenceMaterial;

    public ShrimpFraction() {
        fractionID = "NONE";
        spotNumber = -1;
        dateTimeMilliseconds = 0l;
        countTimeSec = new double[0];
        isotopicRatios = new HashMap<>();
        rawPeakData = new int[0][0];
        extractedRunData = new double[0][0];
        totalCps = new double[0];
        netPkCps = new double[0][0];
        pkFerr = new double[0][0];
        referenceMaterial = false;

    }

    public ShrimpFraction(String fractionID, Map<RawRatioNamesSHRIMP, IsotopeRatioModelSHRIMP> isotopicRatios) {
        this();
        this.fractionID = fractionID;
        this.isotopicRatios = isotopicRatios;
    }

    /**
     * @return the fractionID
     */
    public String getFractionID() {
        return fractionID;
    }

    /**
     * @param fractionID the fractionID to set
     */
    public void setFractionID(String fractionID) {
        this.fractionID = fractionID;
    }

    /**
     * @return the spotNumber
     */
    public int getSpotNumber() {
        return spotNumber;
    }

    /**
     * @param spotNumber the spotNumber to set
     */
    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    /**
     * @return the dateTimeMilliseconds
     */
    public long getDateTimeMilliseconds() {
        return dateTimeMilliseconds;
    }

    /**
     * @param dateTimeMilliseconds the dateTimeMilliseconds to set
     */
    public void setDateTimeMilliseconds(long dateTimeMilliseconds) {
        this.dateTimeMilliseconds = dateTimeMilliseconds;
    }

    /**
     * @return the deadTimeNanoseconds
     */
    public int getDeadTimeNanoseconds() {
        return deadTimeNanoseconds;
    }

    /**
     * @param aDeadTimeNanoseconds the deadTimeNanoseconds to set
     */
    public void setDeadTimeNanoseconds(int aDeadTimeNanoseconds) {
        deadTimeNanoseconds = aDeadTimeNanoseconds;
    }

    /**
     * @return the sbmZeroCps
     */
    public int getSbmZeroCps() {
        return sbmZeroCps;
    }

    /**
     * @param sbmZeroCps the sbmZeroCps to set
     */
    public void setSbmZeroCps(int sbmZeroCps) {
        this.sbmZeroCps = sbmZeroCps;
    }

    /**
     * @return the countTimeSec
     */
    public double[] getCountTimeSec() {
        return countTimeSec;
    }

    /**
     * @param countTimeSec the countTimeSec to set
     */
    public void setCountTimeSec(double[] countTimeSec) {
        this.countTimeSec = countTimeSec;
    }

    /**
     * @return the isotopicRatios
     */
    public Map<RawRatioNamesSHRIMP, IsotopeRatioModelSHRIMP> getIsotopicRatios() {
        return isotopicRatios;
    }

    /**
     * @param isotopicRatios the isotopicRatios to set
     */
    public void setIsotopicRatios(Map<RawRatioNamesSHRIMP, IsotopeRatioModelSHRIMP> isotopicRatios) {
        this.isotopicRatios = isotopicRatios;
    }

    /**
     * @return the rawPeakData
     */
    public int[][] getRawPeakData() {
        return rawPeakData;
    }

    /**
     * @param rawPeakData the rawPeakData to set
     */
    public void setRawPeakData(int[][] rawPeakData) {
        this.rawPeakData = rawPeakData;
    }

    /**
     * @return the rawSBMData
     */
    public int[][] getRawSBMData() {
        return rawSBMData;
    }

    /**
     * @param rawSBMData the rawSBMData to set
     */
    public void setRawSBMData(int[][] rawSBMData) {
        this.rawSBMData = rawSBMData;
    }

    /**
     * @return the extractedRunData
     */
    public double[][] getExtractedRunData() {
        return extractedRunData;
    }

    /**
     * @param extractedRunData the extractedRunData to set
     */
    public void setExtractedRunData(double[][] extractedRunData) {
        this.extractedRunData = extractedRunData;
    }

    /**
     * @return the totalCounts
     */
    public double[][] getTotalCounts() {
        return totalCounts;
    }

    /**
     * @param totalCounts the totalCounts to set
     */
    public void setTotalCounts(double[][] totalCounts) {
        this.totalCounts = totalCounts;
    }

    /**
     * @return the totalCountsOneSigmaAbs
     */
    public double[][] getTotalCountsOneSigmaAbs() {
        return totalCountsOneSigmaAbs;
    }

    /**
     * @param totalCountsOneSigmaAbs the totalCountsOneSigmaAbs to set
     */
    public void setTotalCountsOneSigmaAbs(double[][] totalCountsOneSigmaAbs) {
        this.totalCountsOneSigmaAbs = totalCountsOneSigmaAbs;
    }

    /**
     * @return the totalCountsSBM
     */
    public double[][] getTotalCountsSBM() {
        return totalCountsSBM;
    }

    /**
     * @param totalCountsSBM the totalCountsSBM to set
     */
    public void setTotalCountsSBM(double[][] totalCountsSBM) {
        this.totalCountsSBM = totalCountsSBM;
    }

    /**
     * @return the timeStampSec
     */
    public double[][] getTimeStampSec() {
        return timeStampSec;
    }

    /**
     * @param timeStampSec the timeStampSec to set
     */
    public void setTimeStampSec(double[][] timeStampSec) {
        this.timeStampSec = timeStampSec;
    }

    /**
     * @return the trimMass
     */
    public double[][] getTrimMass() {
        return trimMass;
    }

    /**
     * @param trimMass the trimMass to set
     */
    public void setTrimMass(double[][] trimMass) {
        this.trimMass = trimMass;
    }

    /**
     * @return the totalCps
     */
    public double[] getTotalCps() {
        return totalCps;
    }

    /**
     * @param totalCps the totalCps to set
     */
    public void setTotalCps(double[] totalCps) {
        this.totalCps = totalCps;
    }

    /**
     * @return the netPkCps
     */
    public double[][] getNetPkCps() {
        return netPkCps;
    }

    /**
     * @param aNetPkCps the netPkCps to set
     */
    public void setNetPkCps(double[][] aNetPkCps) {
        netPkCps = aNetPkCps;
    }

    /**
     * @return the pkFerr
     */
    public double[][] getPkFerr() {
        return pkFerr;
    }

    /**
     * @param aPkFerr the pkFerr to set
     */
    public void setPkFerr(double[][] aPkFerr) {
        pkFerr = aPkFerr;
    }

    /**
     * @return the referenceMaterial
     */
    public boolean isReferenceMaterial() {
        return referenceMaterial;
    }

    /**
     * @param referenceMaterial the referenceMaterial to set
     */
    public void setReferenceMaterial(boolean referenceMaterial) {
        this.referenceMaterial = referenceMaterial;
    }

}