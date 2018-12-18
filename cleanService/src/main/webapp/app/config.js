/**
 * Created by phoenix on 14/11/7.
 */
serverLocation = window.location.origin;
xyxPay.constant('xyxUtil',
    {
        WEBROOTURL: serverLocation + '/cconsole/api/v1/',
        BASEURL: serverLocation + '/cconsole/',
        DEFAULT_PAGE_SIZE: 10,
        PRODUCTS_PAGE_SIZE: 10,
        TYPEAHEAD_CACHE_SIZE: 10,
        removeDuplicateFromArray: function (arr, prop) {
            return arr.filter(function (obj, pos, arr) {
                return arr.map(function (mapObj) {
                        return mapObj[prop];
                    }).indexOf(obj[prop]) === pos;
            });
        },
        downloadSVG: function (fileName, noty) {
            var svg = $("#diagram").find('svg')[0];
            if (!svg) {
                noty.show("No image to draw.", "error");
            }
            //get svg source.
            var serializer = new XMLSerializer();
            var source = serializer.serializeToString(svg);
            //add name spaces.
            if (!source.match(/^<svg[^>]+xmlns="http\:\/\/www\.w3\.org\/2000\/svg"/)) {
                source = source.replace(/^<svg/, '<svg xmlns="http://www.w3.org/2000/svg"');
            }
            if (!source.match(/^<svg[^>]+"http\:\/\/www\.w3\.org\/1999\/xlink"/)) {
                source = source.replace(/^<svg/, '<svg xmlns:xlink="http://www.w3.org/1999/xlink"');
            }
            //add xml declaration
            source = '<?xml version="1.0" standalone="no"?>\r\n' + source;
            //convert svg source to URI data scheme.
            var url = "data:image/svg+xml;charset=utf-8," + encodeURIComponent(source);
            var evt = new MouseEvent('click', {
                view: window,
                bubbles: false,
                cancelable: true
            });
            var a = document.createElement('a');
            a.setAttribute('download', fileName + '.svg');
            a.setAttribute('href', url);
            a.setAttribute('target', '_blank');
            a.dispatchEvent(evt);
        },
        getSvgTitleScript: function (title) {
            return "Title: " + title + "\n";
        },

        upperCaseForFirstChar: function (inputString) {
            inputString = inputString.toLowerCase();
            var reg = /\b(\w)|\s(\w)/g;
            return inputString.replace(reg, function (m) {
                return m.toUpperCase()
            });
        }

        ,
        countTotal: function (numArray) {
            var total = 0;
            for (var i = 0; i < numArray.length; i++) {
                total += numArray[i];
            }
            return total;
        }
        ,
        disdictByColumn: function (sourceList, disCol) {
            var tempList = [];
            for (var i = 0; i < sourceList.length; i++) {
                if (tempList.indexOf(sourceList[i][disCol]) < 0) {
                    tempList.push(sourceList[i][disCol]);
                }
            }
            return tempList;

        },
        isNumeric: function (number) {
            return !isNaN(parseFloat(number)) && isFinite(number);
        },
        disdictByWithAggregateData: function (sourceList, disCol, aggrateCol) {
            var tempList = [];
            var markedList = [];
            for (var i = 0; i < sourceList.length; i++) {
                if (markedList.indexOf(sourceList[i][disCol]) < 0) {
                    markedList.push(sourceList[i][disCol]);
                    tempList.push(sourceList[i]);
                } else {
                    for (var j = 0; j < tempList.length; j++) {
                        if (sourceList[i][disCol] == tempList[j][disCol]) {
                            tempList[j][aggrateCol] += sourceList[i][aggrateCol];
                        }
                    }

                }
            }
            return tempList;
        }
        ,
        findObjectExistInArray: function findWithAttr(array, attr, value) {
            for (var i = 0; i < array.length; i += 1) {
                if (array[i][attr] === value) {
                    return i;
                }
            }
            return -1;
        }
        ,
        isValidEmailAddress: function (emailAddress) {
            var pattern = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return pattern.test(emailAddress);
        }
        ,
        GET_FORMATED_DATE_TODAY: function () {
            var date = new Date();
            var result = parseInt(date.getTime());
            return result;
        }
        ,
        isNullOrEmptyOrUndefined: function (value) {
            return !value || value == "";
        }
        ,
        by: function (name, minor) {
            return function (o, p) {
                var a, b;
                if (o && p && typeof o === 'object' && typeof p === 'object') {
                    a = o[name];
                    b = p[name];
                    if (a === b) {
                        return typeof minor === 'function' ? minor(o, p) : 0;
                    }
                    if (typeof a === typeof b) {
                        return a < b ? -1 : 1;
                    }
                    return typeof a < typeof b ? -1 : 1;
                } else {
                    throw("error");
                }
            }
        },
        genCSV: function (JSONData, deleteArray, showLabel, fileName) {
            //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
            var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
            for (var index = 0; index < arrData.length; index++) {
                if (null != deleteArray) {
                    for (var x = 0; x < deleteArray.length; x++)
                        delete arrData[index][deleteArray[x]];
                }
            }
            var CSV = "\ufeff";
            //Set Report title in first row or line

            //This condition will generate the Label/Header
            if (showLabel) {
                var row = "";
                //This loop will extract the label from 1st index of on array
                for (var index in arrData[0]) {
                    //Now convert each value to string and comma-seprated
                    row += index + ',';
                }
                row = row.slice(0, -1);
                //append Label row with line break
                CSV += row + '\r\n';
            }
            //1st loop is to extract each row
            for (var i = 0; i < arrData.length; i++) {
                var row = "";
                //2nd loop will extract each column and convert it in string comma-seprated
                for (var index in arrData[i]) {
                    var coulmn = arrData[i][index];
                    if (typeof(coulmn) == "number" && (coulmn + '').length == 13) {
                        coulmn = $filter('date')(new Date(coulmn), "yyyy-MM-ddTHH:mm:ss.sssZ");
                    } else if (typeof(coulmn) == 'object') {
                        coulmn = JSON.stringify(coulmn);
                    }
                    if (typeof(coulmn) == "string") {
                        coulmn = coulmn.replace(/\"/g, "\"\"");
                    }
                    row += '"' + coulmn + '",';
                    //row += '"' + arrData[i][index] + '",';
                }
                row.slice(0, row.length - 1);
                //add a line break after each row
                CSV += row + '\r\n';
            }
            if (CSV == '') {
                alert("Invalid data");
                return;
            }
            //Generate a file name
            var tempfileName = typeof fileName == 'string' && fileName.length > 0 ? fileName : "FAS_MetaData";
            var fileName = tempfileName + "_" + new Date().getTime();
            //this will remove the blank-spaces from the title and replace it with an underscore
            //fileName += ReportTitle.replace(/ /g, "_");
            //Initialize file format you want csv or xls
            CSV = new Blob([CSV], {type: 'text/csv'});
            var uri = URL.createObjectURL(CSV);
            // Now the little tricky part.
            // you can use either>> window.open(uri);
            // but this will not work in some browsers
            // or you will not get the correct file extension
            //this trick will generate a temp <a /> tag
            var link = document.createElement("a");
            link.href = uri;
            //set the visibility hidden so it will not effect on your web-layout
            link.style = "visibility:hidden";
            link.download = fileName + ".csv";
            //this part will append the anchor tag and remove it after automatic click
            document.body.appendChild(link);
            link.click();
            document.body.removeChild(link);

        }
    });

