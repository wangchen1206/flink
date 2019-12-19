package com.flink.flinksource;

import java.util.List;

/**
 * @Author: cc
 * @Date: 2019/11/7 15:11
 */
public class User {

    /**
     * randomId : 0bf60a7d-10a2-4a72-a6ed-12e3593e37d9
     * board : {"setupUrl":"","macAddress":"02:92:79:13:0a:7d","printers":[{"serialNumber":"VNC3D00704","cartridges":[{"serialNumber":"234951571","level":"8","familyName":"Black toner supply","pagesUsed":1,"productNumber":"CF231A","state":"ok","consumableType":"toner","estimatedPagesRemaining":20}],"color":false,"nickName":"Box Mock Printer1","ipv4Address":"","trays":[{"size":"any","duplex":true,"trayIndex":1,"type":"auto"}],"counter":{"jamEvents":14,"totalImpressions":3772,"copyImpressions":482,"duplexSheets":693},"productNumber":"G3Q76D","uuid":"printer111111","sid":1,"upTime":1425591870,"scanner":{"jamEvents":0,"adfImages":0,"flatbedImages":0},"isUsbConnected":true,"model":"HP LaserJet Ultra MFP M230sdn Mock1","status":"ready"}],"hwversion":"1.0.0","latitude":0,"ipv4Address":"192.168.202.129","supportUrl":"","model":"m0.1","pid":"18783","firmware":"0.1","uuid":"board111111","longitude":0}
     * command : board
     * platformCode : veryprint
     */

    private String randomId;
    private BoardBean board;
    private String command;
    private String platformCode;

    public String getRandomId() {
        return randomId;
    }

    public void setRandomId(String randomId) {
        this.randomId = randomId;
    }

    public BoardBean getBoard() {
        return board;
    }

    public void setBoard(BoardBean board) {
        this.board = board;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public static class BoardBean {
        /**
         * setupUrl :
         * macAddress : 02:92:79:13:0a:7d
         * printers : [{"serialNumber":"VNC3D00704","cartridges":[{"serialNumber":"234951571","level":"8","familyName":"Black toner supply","pagesUsed":1,"productNumber":"CF231A","state":"ok","consumableType":"toner","estimatedPagesRemaining":20}],"color":false,"nickName":"Box Mock Printer1","ipv4Address":"","trays":[{"size":"any","duplex":true,"trayIndex":1,"type":"auto"}],"counter":{"jamEvents":14,"totalImpressions":3772,"copyImpressions":482,"duplexSheets":693},"productNumber":"G3Q76D","uuid":"printer111111","sid":1,"upTime":1425591870,"scanner":{"jamEvents":0,"adfImages":0,"flatbedImages":0},"isUsbConnected":true,"model":"HP LaserJet Ultra MFP M230sdn Mock1","status":"ready"}]
         * hwversion : 1.0.0
         * latitude : 0.0
         * ipv4Address : 192.168.202.129
         * supportUrl :
         * model : m0.1
         * pid : 18783
         * firmware : 0.1
         * uuid : board111111
         * longitude : 0.0
         */

        private String setupUrl;
        private String macAddress;
        private String hwversion;
        private double latitude;
        private String ipv4Address;
        private String supportUrl;
        private String model;
        private String pid;
        private String firmware;
        private String uuid;
        private double longitude;
        private List<PrintersBean> printers;

        public String getSetupUrl() {
            return setupUrl;
        }

        public void setSetupUrl(String setupUrl) {
            this.setupUrl = setupUrl;
        }

        public String getMacAddress() {
            return macAddress;
        }

        public void setMacAddress(String macAddress) {
            this.macAddress = macAddress;
        }

        public String getHwversion() {
            return hwversion;
        }

        public void setHwversion(String hwversion) {
            this.hwversion = hwversion;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getIpv4Address() {
            return ipv4Address;
        }

        public void setIpv4Address(String ipv4Address) {
            this.ipv4Address = ipv4Address;
        }

        public String getSupportUrl() {
            return supportUrl;
        }

        public void setSupportUrl(String supportUrl) {
            this.supportUrl = supportUrl;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getFirmware() {
            return firmware;
        }

        public void setFirmware(String firmware) {
            this.firmware = firmware;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public List<PrintersBean> getPrinters() {
            return printers;
        }

        public void setPrinters(List<PrintersBean> printers) {
            this.printers = printers;
        }

        public static class PrintersBean {
            /**
             * serialNumber : VNC3D00704
             * cartridges : [{"serialNumber":"234951571","level":"8","familyName":"Black toner supply","pagesUsed":1,"productNumber":"CF231A","state":"ok","consumableType":"toner","estimatedPagesRemaining":20}]
             * color : false
             * nickName : Box Mock Printer1
             * ipv4Address :
             * trays : [{"size":"any","duplex":true,"trayIndex":1,"type":"auto"}]
             * counter : {"jamEvents":14,"totalImpressions":3772,"copyImpressions":482,"duplexSheets":693}
             * productNumber : G3Q76D
             * uuid : printer111111
             * sid : 1
             * upTime : 1425591870
             * scanner : {"jamEvents":0,"adfImages":0,"flatbedImages":0}
             * isUsbConnected : true
             * model : HP LaserJet Ultra MFP M230sdn Mock1
             * status : ready
             */

            private String serialNumber;
            private boolean color;
            private String nickName;
            private String ipv4Address;
            private CounterBean counter;
            private String productNumber;
            private String uuid;
            private int sid;
            private int upTime;
            private ScannerBean scanner;
            private boolean isUsbConnected;
            private String model;
            private String status;
            private List<CartridgesBean> cartridges;
            private List<TraysBean> trays;

            public String getSerialNumber() {
                return serialNumber;
            }

            public void setSerialNumber(String serialNumber) {
                this.serialNumber = serialNumber;
            }

            public boolean isColor() {
                return color;
            }

            public void setColor(boolean color) {
                this.color = color;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getIpv4Address() {
                return ipv4Address;
            }

            public void setIpv4Address(String ipv4Address) {
                this.ipv4Address = ipv4Address;
            }

            public CounterBean getCounter() {
                return counter;
            }

            public void setCounter(CounterBean counter) {
                this.counter = counter;
            }

            public String getProductNumber() {
                return productNumber;
            }

            public void setProductNumber(String productNumber) {
                this.productNumber = productNumber;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public int getUpTime() {
                return upTime;
            }

            public void setUpTime(int upTime) {
                this.upTime = upTime;
            }

            public ScannerBean getScanner() {
                return scanner;
            }

            public void setScanner(ScannerBean scanner) {
                this.scanner = scanner;
            }

            public boolean isIsUsbConnected() {
                return isUsbConnected;
            }

            public void setIsUsbConnected(boolean isUsbConnected) {
                this.isUsbConnected = isUsbConnected;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<CartridgesBean> getCartridges() {
                return cartridges;
            }

            public void setCartridges(List<CartridgesBean> cartridges) {
                this.cartridges = cartridges;
            }

            public List<TraysBean> getTrays() {
                return trays;
            }

            public void setTrays(List<TraysBean> trays) {
                this.trays = trays;
            }

            public static class CounterBean {
                /**
                 * jamEvents : 14
                 * totalImpressions : 3772
                 * copyImpressions : 482
                 * duplexSheets : 693
                 */

                private int jamEvents;
                private int totalImpressions;
                private int copyImpressions;
                private int duplexSheets;

                public int getJamEvents() {
                    return jamEvents;
                }

                public void setJamEvents(int jamEvents) {
                    this.jamEvents = jamEvents;
                }

                public int getTotalImpressions() {
                    return totalImpressions;
                }

                public void setTotalImpressions(int totalImpressions) {
                    this.totalImpressions = totalImpressions;
                }

                public int getCopyImpressions() {
                    return copyImpressions;
                }

                public void setCopyImpressions(int copyImpressions) {
                    this.copyImpressions = copyImpressions;
                }

                public int getDuplexSheets() {
                    return duplexSheets;
                }

                public void setDuplexSheets(int duplexSheets) {
                    this.duplexSheets = duplexSheets;
                }
            }

            public static class ScannerBean {
                /**
                 * jamEvents : 0
                 * adfImages : 0
                 * flatbedImages : 0
                 */

                private int jamEvents;
                private int adfImages;
                private int flatbedImages;

                public int getJamEvents() {
                    return jamEvents;
                }

                public void setJamEvents(int jamEvents) {
                    this.jamEvents = jamEvents;
                }

                public int getAdfImages() {
                    return adfImages;
                }

                public void setAdfImages(int adfImages) {
                    this.adfImages = adfImages;
                }

                public int getFlatbedImages() {
                    return flatbedImages;
                }

                public void setFlatbedImages(int flatbedImages) {
                    this.flatbedImages = flatbedImages;
                }
            }

            public static class CartridgesBean {
                /**
                 * serialNumber : 234951571
                 * level : 8
                 * familyName : Black toner supply
                 * pagesUsed : 1
                 * productNumber : CF231A
                 * state : ok
                 * consumableType : toner
                 * estimatedPagesRemaining : 20
                 */

                private String serialNumber;
                private String level;
                private String familyName;
                private int pagesUsed;
                private String productNumber;
                private String state;
                private String consumableType;
                private int estimatedPagesRemaining;

                public String getSerialNumber() {
                    return serialNumber;
                }

                public void setSerialNumber(String serialNumber) {
                    this.serialNumber = serialNumber;
                }

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getFamilyName() {
                    return familyName;
                }

                public void setFamilyName(String familyName) {
                    this.familyName = familyName;
                }

                public int getPagesUsed() {
                    return pagesUsed;
                }

                public void setPagesUsed(int pagesUsed) {
                    this.pagesUsed = pagesUsed;
                }

                public String getProductNumber() {
                    return productNumber;
                }

                public void setProductNumber(String productNumber) {
                    this.productNumber = productNumber;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getConsumableType() {
                    return consumableType;
                }

                public void setConsumableType(String consumableType) {
                    this.consumableType = consumableType;
                }

                public int getEstimatedPagesRemaining() {
                    return estimatedPagesRemaining;
                }

                public void setEstimatedPagesRemaining(int estimatedPagesRemaining) {
                    this.estimatedPagesRemaining = estimatedPagesRemaining;
                }
            }

            public static class TraysBean {
                /**
                 * size : any
                 * duplex : true
                 * trayIndex : 1
                 * type : auto
                 */

                private String size;
                private boolean duplex;
                private int trayIndex;
                private String type;

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public boolean isDuplex() {
                    return duplex;
                }

                public void setDuplex(boolean duplex) {
                    this.duplex = duplex;
                }

                public int getTrayIndex() {
                    return trayIndex;
                }

                public void setTrayIndex(int trayIndex) {
                    this.trayIndex = trayIndex;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }
            }
        }
    }
}
