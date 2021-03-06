/*
 * Copyright 2015 CIRDLES.
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
package org.earthtime.fractions;

import java.awt.geom.Path2D;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import org.earthtime.UPb_Redux.ReduxConstants;
import org.earthtime.UPb_Redux.fractions.UPbReduxFractions.UPbFraction;
import org.earthtime.UPb_Redux.fractions.UPbReduxFractions.UPbLegacyFraction;
import org.earthtime.UPb_Redux.utilities.comparators.IntuitiveStringComparator;
import org.earthtime.UPb_Redux.valueModels.MeasuredRatioModel;
import org.earthtime.UPb_Redux.valueModels.ValueModel;
import org.earthtime.dataDictionaries.DataDictionary;
import org.earthtime.dataDictionaries.MeasuredRatios;
import org.earthtime.dataDictionaries.RadDates;
import org.earthtime.dataDictionaries.TraceElements;
import org.earthtime.ratioDataModels.AbstractRatiosDataModel;

/**
 *
 * @author James F. Bowring <bowring at gmail.com>
 */
public interface ETFractionInterface {

    /**
     *
     * @return
     */
    abstract boolean isFiltered();

    /**
     *
     * @param rejected
     */
    abstract void setFiltered(boolean rejected);

    /**
     *
     * @return
     */
    abstract boolean isRejected();

    /**
     *
     * @param rejected
     */
    abstract void setRejected(boolean rejected);

    /**
     *
     * @return
     */
    abstract boolean isChanged();

    /**
     *
     * @param changed
     */
    abstract void setChanged(boolean changed);

    /**
     *
     * @return
     */
    public boolean isStandard();

    /**
     *
     * @param standard
     */
    public void setStandard(boolean standard);

    public boolean isSecondaryStandard();

    public void setSecondaryStandard(boolean secondaryStandard);

    /**
     *
     * @return
     */
    abstract AbstractRatiosDataModel getPhysicalConstantsModel();

    /**
     *
     * @param physicalConstantsModel
     */
    abstract void setPhysicalConstantsModel(AbstractRatiosDataModel physicalConstantsModel);

    public AbstractRatiosDataModel getDetritalUThModel();

    public void setDetritalUThModel(AbstractRatiosDataModel detritalUThModel);

    /**
     *
     * @return
     */
    abstract int getAliquotNumber();

    /**
     *
     * @param aliquotNumber
     */
    abstract void setAliquotNumber(int aliquotNumber);

    /**
     *
     * @return
     */
    abstract String getSampleName();

    /**
     *
     * @param sampleName
     */
    abstract void setSampleName(String sampleName);

    /**
     *
     * @return
     */
    abstract String getFractionID();

    /**
     *
     * @param fractionID
     */
    abstract void setFractionID(String fractionID);

    /**
     *
     * @return
     */
    abstract String getImageURL();

    /**
     *
     * @param imageURL
     */
    abstract void setImageURL(String imageURL);

    /**
     *
     * @return
     */
    abstract Date getTimeStamp();

    /**
     *
     * @param timeStamp
     */
    abstract void setTimeStamp(Date timeStamp);

    /**
     *
     * @return
     */
    abstract BigDecimal getEstimatedDate();

    /**
     *
     * @param estimatedDate
     */
    abstract void setEstimatedDate(BigDecimal estimatedDate);

    /**
     *
     * @return
     */
    abstract String getAnalysisFractionComment();

    /**
     *
     * @param analysisFractionComment
     */
    abstract void setAnalysisFractionComment(String analysisFractionComment);

    /**
     *
     * @return
     */
    abstract ValueModel[] getMeasuredRatios();

    /**
     *
     * @param measuredRatio
     */
    abstract void setMeasuredRatios(ValueModel[] measuredRatio);

    /**
     *
     * @return
     */
    abstract ValueModel[] getRadiogenicIsotopeRatios();

    /**
     *
     * @param radiogenicIsotopeRatios
     */
    abstract void setRadiogenicIsotopeRatios(ValueModel[] radiogenicIsotopeRatios);

    /**
     *
     * @return
     */
    abstract ValueModel[] getCompositionalMeasures();

    /**
     *
     * @param compositionalMeasures
     */
    abstract void setCompositionalMeasures(ValueModel[] compositionalMeasures);

    /**
     *
     * @param ratioName
     * @return
     */
    abstract ValueModel getMeasuredRatioByName(String ratioName);

    /**
     *
     * @param myMeasuredRatio
     * @return
     */
    abstract ValueModel getMeasuredRatioByName(MeasuredRatios myMeasuredRatio);

    /**
     * Used by reflection in reports
     *
     * @param amName
     * @return
     */
    public default ValueModel getAnalysisMeasure(String amName) {
        ValueModel amModel = null;
        for (int i = 0; i < getAnalysisMeasures().length; i++) {
            if (getAnalysisMeasures()[i].getName().equalsIgnoreCase(amName)) {
                amModel = getAnalysisMeasures()[i];
            }
        }

        if (amModel == null) {
            // return a new model - handles backwards compatible
            // have to add element to array
            ValueModel[] temp = new ValueModel[getAnalysisMeasures().length + 1];
            System.arraycopy(getAnalysisMeasures(), 0, temp, 0, getAnalysisMeasures().length);

            amModel
                    = new ValueModel(amName,
                            BigDecimal.ZERO,
                            "ABS",
                            BigDecimal.ZERO, BigDecimal.ZERO);

            temp[getAnalysisMeasures().length] = amModel;

            setAnalysisMeasures(temp);
        }

        return amModel;
    }

    /**
     *
     * @return
     */
    public ValueModel[] getAnalysisMeasures();

    /**
     *
     * @param analysisMeasures
     */
    public void setAnalysisMeasures(ValueModel[] analysisMeasures);

    /**
     *
     * @param riaName
     * @param valueModel
     */
    public default void setRadiogenicIsotopeDateByName(String riaName, ValueModel valueModel) {
        // make sure it exists
        getRadiogenicIsotopeDateByName(riaName.trim());

        for (int i = 0; i < getIsotopeDates().length; i++) {
            if (getIsotopeDates()[i].getName().equalsIgnoreCase(riaName.trim())) {
                getIsotopeDates()[i] = valueModel;
            }
        }
    }

    /**
     *
     * @param riaName
     * @param valueModel
     */
    public default void setRadiogenicIsotopeDateByName(RadDates riaName, ValueModel valueModel) {
        setRadiogenicIsotopeDateByName(riaName.getName(), valueModel);
    }

    /**
     *
     * @param ratioName
     * @return
     */
    public default ValueModel getRadiogenicIsotopeDateByName(String ratioName) {
        for (ValueModel radiogenicIsotopeDate : getIsotopeDates()) {
            if (radiogenicIsotopeDate.getName().equalsIgnoreCase(ratioName.trim())) {
                return radiogenicIsotopeDate;
            }
        }

        // return a new model - handles backwards compatible
        // have to add element to array
        ValueModel[] temp = new ValueModel[getIsotopeDates().length + 1];
        System.arraycopy(getIsotopeDates(), 0, temp, 0, getIsotopeDates().length);

        ValueModel riaModel
                = new ValueModel(ratioName.trim(),
                        BigDecimal.ZERO,
                        "ABS",
                        BigDecimal.ZERO, BigDecimal.ZERO);

        temp[getIsotopeDates().length] = riaModel;

        setIsotopeDates(temp);

        return riaModel;

    }

    /**
     *
     * @param ratioName
     * @return
     */
    public default ValueModel getRadiogenicIsotopeDateByName(RadDates ratioName) {
        return getRadiogenicIsotopeDateByName(ratioName.getName());
    }

    /**
     *
     * @return
     */
    public ValueModel[] getIsotopeDates();

    /**
     *
     * @param radiogenicIsotopeDates
     */
    public void setIsotopeDates(ValueModel[] radiogenicIsotopeDates);

    /**
     *
     * @param riaName
     * @param valueModel
     */
    public default void setRadiogenicIsotopeRatioByName(String riaName, ValueModel valueModel) {
        // make sure it exists
        getRadiogenicIsotopeRatioByName(riaName.trim());

        for (int i = 0; i < getRadiogenicIsotopeRatios().length; i++) {
            if (getRadiogenicIsotopeRatios()[i].getName().equalsIgnoreCase(riaName.trim())) {
                getRadiogenicIsotopeRatios()[i] = valueModel;
            }
        }
    }

    /**
     *
     * @param ratioName
     * @return
     */
    public default ValueModel getRadiogenicIsotopeRatioByName(String ratioName) {
        for (ValueModel radiogenicIsotopeRatio : getRadiogenicIsotopeRatios()) {
            if (radiogenicIsotopeRatio.getName().equalsIgnoreCase(ratioName.trim())) {
                return radiogenicIsotopeRatio;
            }
        }

        // return a new model - handles backwards compatible
        // have to add element to array
        ValueModel[] temp = new ValueModel[getRadiogenicIsotopeRatios().length + 1];
        System.arraycopy(getRadiogenicIsotopeRatios(), 0, temp, 0, getRadiogenicIsotopeRatios().length);

        ValueModel rirModel
                = new ValueModel(ratioName.trim(),
                        ratioName.startsWith("rho")
                        ?//
                        new BigDecimal(ReduxConstants.NO_RHO_FLAG, ReduxConstants.mathContext15) //
                        : BigDecimal.ZERO,// June 2010 to force out of range of legal cov [-1,,,1]0.0;
                        "ABS",
                        BigDecimal.ZERO, BigDecimal.ZERO);

        temp[getRadiogenicIsotopeRatios().length] = rirModel;

        setRadiogenicIsotopeRatios(temp);

        return rirModel;
    }

    /**
     * @return the isLegacy
     */
    public boolean isLegacy();

    /**
     *
     * @param amName
     * @param valueModel
     */
    public default void setAnalysisMeasureByName(String amName, ValueModel valueModel) {
        // make sure it exists
        getAnalysisMeasure(amName.trim());
        for (int i = 0; i < getAnalysisMeasures().length; i++) {
            if (getAnalysisMeasures()[i].getName().equalsIgnoreCase(amName.trim())) {
                getAnalysisMeasures()[i] = valueModel;
            }
        }
    }

    /**
     *
     * @param sirName
     * @return
     */
    public default ValueModel getSampleIsochronRatiosByName(String sirName) {
        for (int i = 0; i < getSampleIsochronRatios().length; i++) {
            if (getSampleIsochronRatios()[i].getName().equalsIgnoreCase(sirName.trim())) {
                return getSampleIsochronRatios()[i];
            }
        }
        // return a new model - handles backwards compatible
        // have to add element to array
        ValueModel[] temp = new ValueModel[getSampleIsochronRatios().length + 1];
        System.arraycopy(getSampleIsochronRatios(), 0, temp, 0, getSampleIsochronRatios().length);

        ValueModel sirModel
                = new ValueModel(sirName.trim(),
                        BigDecimal.ZERO,
                        "ABS",
                        BigDecimal.ZERO, BigDecimal.ZERO);

        temp[getSampleIsochronRatios().length] = sirModel;

        setSampleIsochronRatios(temp);

        return sirModel;
    }

    /**
     *
     * @param sirName
     * @param valueModel
     */
    public default void setSampleIsochronRatiosByName(String sirName, ValueModel valueModel) {
        // make sure it exists
        getSampleIsochronRatiosByName(sirName.trim());
        //find it
        for (int i = 0; i < getSampleIsochronRatios().length; i++) {
            if (getSampleIsochronRatios()[i].getName().equalsIgnoreCase(sirName.trim())) {
                getSampleIsochronRatios()[i] = valueModel;
            }
        }
    }

    /**
     *
     * @return
     */
    public ValueModel[] getSampleIsochronRatios();

    /**
     *
     * @param sampleIsochronRatios
     */
    public void setSampleIsochronRatios(ValueModel[] sampleIsochronRatios);

    /**
     *
     * @return
     */
    public default ValueModel[] copyAnalysisMeasures() {
        ValueModel[] retval = new ValueModel[getAnalysisMeasures().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getAnalysisMeasures()[i].copy();
        }
        return retval;
    }

    /**
     *
     * @return
     */
    public default ValueModel[] copyCompositionalMeasures() {
        ValueModel[] retval = new ValueModel[getCompositionalMeasures().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getCompositionalMeasures()[i].copy();
        }
        return retval;
    }

    /**
     *
     * @return
     */
    public default ValueModel[] copyMeasuredRatios() {
        ValueModel[] retval = new MeasuredRatioModel[getMeasuredRatios().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getMeasuredRatios()[i].copy();
        }
        return retval;
    }

    /**
     *
     * @return
     */
    public default ValueModel[] copyRadiogenicIsotopeDates() {
        ValueModel[] retval = new ValueModel[getIsotopeDates().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getIsotopeDates()[i].copy();
        }
        return retval;
    }

    /**
     *
     * @return
     */
    public default ValueModel[] copyRadiogenicIsotopeRatios() {
        ValueModel[] retval = new ValueModel[getRadiogenicIsotopeRatios().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getRadiogenicIsotopeRatios()[i].copy();
        }
        return retval;
    }

    /**
     *
     * @return
     */
    public default ValueModel[] copySampleIsochronRatios() {
        ValueModel[] retval = new ValueModel[getSampleIsochronRatios().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getSampleIsochronRatios()[i].copy();
        }
        return retval;
    }

    /**
     *
     * @return
     */
    public default ValueModel[] copyTraceElements() {
        ValueModel[] retval = new ValueModel[getTraceElements().length];
        for (int i = 0; i < retval.length; i++) {
            retval[i] = getTraceElements()[i].copy();
        }
        return retval;
    }

    /**
     * @return the traceElements
     */
    public ValueModel[] getTraceElements();

    /**
     * @param traceElements the traceElements to set
     */
    public void setTraceElements(ValueModel[] traceElements);

    /**
     *
     * @param tmName
     * @return
     */
    public default ValueModel getTraceElementByName(String tmName) {
        for (ValueModel traceElement : getTraceElements()) {
            if (traceElement.getName().equalsIgnoreCase(tmName.trim())) {
                return traceElement;
            }
        }
        // return a new model - handles backwards compatible
        // have to add element to array
        ValueModel[] temp = new ValueModel[getTraceElements().length + 1];
        System.arraycopy(getTraceElements(), 0, temp, 0, getTraceElements().length);

        ValueModel trModel
                = new ValueModel(tmName.trim(),
                        BigDecimal.ZERO,
                        "ABS",
                        BigDecimal.ZERO, BigDecimal.ZERO);

        temp[getTraceElements().length] = trModel;

        setTraceElements(temp);

        return trModel;
    }

    /*
     needed summer 2014 for backward compatibility
     */
    public default void initializeTraceElements() {
        setTraceElements(new ValueModel[TraceElements.getNames().length]);
        for (int i = 0; i < TraceElements.getNames().length; i++) {
            getTraceElements()[i]
                    = new ValueModel(TraceElements.getNames()[i],
                            BigDecimal.ZERO,
                            "PCT",
                            BigDecimal.ZERO, BigDecimal.ZERO);
        }
    }

    /**
     * @param isLegacy the isLegacy to set
     */
    public void setLegacy(boolean legacy);

    /**
     *
     * @param cmName
     * @return
     */
    public default ValueModel getCompositionalMeasureByName(String cmName) {
        for (int i = 0; i < getCompositionalMeasures().length; i++) {
            if (getCompositionalMeasures()[i].getName().equalsIgnoreCase(cmName.trim())) {
                return getCompositionalMeasures()[i];
            }
        }
        // return a new model - handles backwards compatible
        // have to add element to array
        ValueModel[] temp = new ValueModel[getCompositionalMeasures().length + 1];
        System.arraycopy(getCompositionalMeasures(), 0, temp, 0, getCompositionalMeasures().length);

        ValueModel crModel
                = new ValueModel(cmName.trim(),
                        BigDecimal.ZERO,
                        "ABS",
                        BigDecimal.ZERO, BigDecimal.ZERO);

        temp[getCompositionalMeasures().length] = crModel;

        setCompositionalMeasures(temp);

        return crModel;
    }

    /**
     *
     * @param cmName
     * @param valueModel
     */
    public default void setCompositionalMeasureByName(String cmName, ValueModel valueModel) {
        // make sure it exists
        getCompositionalMeasureByName(cmName.trim());
        //find it
        for (int i = 0; i < getCompositionalMeasures().length; i++) {
            if (getCompositionalMeasures()[i].getName().equalsIgnoreCase(cmName.trim())) {
                getCompositionalMeasures()[i] = valueModel;
            }
        }
    }

    /**
     *
     * @return
     */
    public String getPhysicalConstantsModelID();

    /**
     *
     * @return
     */
    abstract String getRatioType();

    /**
     *
     * @param RatioType
     */
    abstract void setRatioType(String RatioType);

    /**
     *
     * @return
     */
    abstract String getFractionNotes();

    /**
     *
     * @param fractionNotes
     */
    abstract void setFractionNotes(String fractionNotes);

    /**
     *
     */
    abstract void toggleRejectedStatus();

    /**
     *
     * @return
     */
    abstract boolean isDeleted();

    /**
     *
     * @param deleted
     */
    abstract void setDeleted(boolean deleted);

    /**
     *
     * @return
     */
    abstract Path2D getErrorEllipsePath();

    /**
     *
     * @param errorEllipsePath
     */
    abstract void setErrorEllipsePath(Path2D errorEllipsePath);

    /**
     *
     * @return
     */
    abstract double getEllipseRho();

    /**
     *
     * @param ellipseRho
     */
    abstract void setEllipseRho(double ellipseRho);

    static final Comparator FRACTION_ID_ORDER = (Object f1, Object f2) -> {
        String fractionTwoID = ((ETFractionInterface) f2).getFractionID().trim();
        String fractionTwoAliquotNum = "1";
        try {
            fractionTwoAliquotNum = String.valueOf(((ETFractionInterface) f2).getAliquotNumber());
        } catch (Exception e) {
        }
        String fractionOneID = ((ETFractionInterface) f1).getFractionID().trim();
        String fractionOneAliquotNum = "1";
        try {
            fractionOneAliquotNum = String.valueOf(((ETFractionInterface) f1).getAliquotNumber());
        } catch (Exception e) {
        }
        // oct 2010 put here
        Comparator<String> forNoah = new IntuitiveStringComparator<>();
//        return forNoah.compare(fractionOneID, fractionTwoID);
        return forNoah.compare((fractionOneAliquotNum + "." + fractionOneID).toUpperCase(), (fractionTwoAliquotNum + "." + fractionTwoID).toUpperCase());

    };

    /**
     *
     * @return
     */
    abstract int getNumberOfGrains();

    /**
     *
     * @param numberOfGrains
     */
    abstract void setNumberOfGrains(int numberOfGrains);

    /**
     * @return the rgbColor
     */
    public int getRgbColor();

    /**
     * @param rgbColor the rgbColor to set
     */
    public void setRgbColor(int rgbColor);

    /**
     * @return the grainID
     */
    public String getGrainID();

    /**
     * @param grainID the grainID to set
     */
    public void setGrainID(String grainID);

    /**
     *
     * @param fraction
     * @param copyAnalysisMeasures
     */
    public void getValuesFrom(ETFractionInterface fraction, boolean copyAnalysisMeasures);

    public default ValueModel[] valueModelArrayFactory(String[] namesArray, String uncertaintyType) {
        ValueModel[] builtArray = new ValueModel[namesArray.length];

        for (int i = 0; i < namesArray.length; i++) {
            builtArray[i]
                    = new ValueModel(namesArray[i],
                            BigDecimal.ZERO,
                            uncertaintyType,
                            BigDecimal.ZERO, BigDecimal.ZERO);
        }

        return builtArray;
    }

    /**
     *
     * @param nameOfValueModel the value of nameOfValueModel
     * @return
     */
    public default ValueModel retrieveValueModelByName(String nameOfValueModel) {
        ValueModel retVal = null;

        // looks up the correct method and applies it to input
        Method meth
                = DataDictionary.retrieveMethodNameForInput(nameOfValueModel);
        if (meth != null) {
            try {
                retVal = (ValueModel) meth.//
                        invoke(this, new Object[]{nameOfValueModel});
            } catch (IllegalAccessException | IllegalArgumentException illegalAccessException) {
            } catch (InvocationTargetException invocationTargetException) {
                System.out.println(invocationTargetException.getMessage() + "  AT retrieveValueModelByName");
            }
        }
        return retVal;
    }

    public default ValueModel[] retrieveXYRho(String nameOfXaxisSourceValueModel, String nameOfYaxisSourceValueModel) {
        ValueModel[] xyRho = new ValueModel[3];
        ValueModel x = retrieveValueModelByName(nameOfXaxisSourceValueModel);
        xyRho[0] = new ValueModel();
        xyRho[0].copyValuesFrom(x);
        if (nameOfXaxisSourceValueModel.toLowerCase().startsWith("age")) {
            xyRho[0].setValue(xyRho[0].getValue().movePointLeft(6));
            xyRho[0].setOneSigma(xyRho[0].getOneSigmaAbs().movePointLeft(6));
        }
        ValueModel y = retrieveValueModelByName(nameOfYaxisSourceValueModel);
        xyRho[1] = new ValueModel();
        xyRho[1].copyValuesFrom(y);
        if (nameOfYaxisSourceValueModel.toLowerCase().startsWith("age")) {
            xyRho[1].setValue(xyRho[1].getValue().movePointLeft(6));
            xyRho[1].setOneSigma(xyRho[1].getOneSigmaAbs().movePointLeft(6));
        }

        xyRho[2] = new ValueModel("RHO",
                BigDecimal.ZERO,
                "NONE", BigDecimal.ZERO, BigDecimal.ZERO);
        try {
            if (this instanceof UPbLegacyFraction) {
                String rhoConcordia = "rhoR206_238r__r207_235r";
                xyRho[2].copyValuesFrom(getRadiogenicIsotopeRatioByName(rhoConcordia));
            } else if (this instanceof UPbFraction) {
                xyRho[2].setValue(((UPbFraction) this).getReductionHandler().calculateAnalyticalRho(nameOfXaxisSourceValueModel, nameOfYaxisSourceValueModel));
            }
        } catch (Exception e) {
        }

        return xyRho;
    }

    public ValueModel getTracerRatioByName(String trName);

    public ValueModel getPbBlankRatioByName(String trName);

    public ValueModel getInitialPbModelRatioByName(String trName);

    public ValueModel getLegacyActivityRatioByName(String arName);
}
