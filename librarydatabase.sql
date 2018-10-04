-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2017 at 07:51 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `librarydatabase`
--
CREATE DATABASE IF NOT EXISTS `librarydatabase` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `librarydatabase`;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(7) NOT NULL,
  `type_id` int(7) NOT NULL,
  `cat_id` int(7) NOT NULL,
  `subcat_id` int(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`book_id`, `type_id`, `cat_id`, `subcat_id`) VALUES
(1, 4, 1, 13);

-- --------------------------------------------------------

--
-- Table structure for table `book_categories`
--

DROP TABLE IF EXISTS `book_categories`;
CREATE TABLE `book_categories` (
  `category_id` int(3) NOT NULL,
  `category` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `book_categories`
--

INSERT INTO `book_categories` (`category_id`, `category`) VALUES
(1, 'Action and Adventure'),
(2, 'Art'),
(3, 'Autobiographies'),
(4, 'Biographies'),
(5, 'Comics'),
(6, 'Cookbooks'),
(7, 'Dictionaries'),
(8, 'Drama'),
(9, 'Encyclopedias'),
(10, 'Fantasy'),
(11, 'Health'),
(12, 'History'),
(13, 'Horror'),
(14, 'Math'),
(15, 'Mystery'),
(16, 'Poetry'),
(17, 'Prayer books'),
(18, 'Romance'),
(19, 'Science'),
(20, 'Science fiction'),
(21, 'Self help'),
(22, 'Series');

-- --------------------------------------------------------

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` int(7) NOT NULL,
  `book_image` longblob,
  `book_isbn` varchar(12) NOT NULL,
  `book_name` varchar(200) NOT NULL,
  `book_title` varchar(200) NOT NULL,
  `book_authors` varchar(200) NOT NULL,
  `book_edition` int(3) NOT NULL,
  `language` varchar(200) NOT NULL,
  `status` varchar(200) NOT NULL,
  `bookcopies` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_info`
--

INSERT INTO `book_info` (`book_id`, `book_image`, `book_isbn`, `book_name`, `book_title`, `book_authors`, `book_edition`, `language`, `status`, `bookcopies`) VALUES
(1, 0xffd8ffe000104a46494600010100000100010000ffdb004300090607080706090807080a0a090b0d160f0d0c0c0d1b14151016201d2222201d1f1f2428342c242631271f1f2d3d2d3135373a3a3a232b3f443f384334393a37ffdb0043011e1e1e2724274e2d2d4ea56f5d6fa5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5a5ffc0001108007900d603012200021101031101ffc4008e00000105010101000000000000000000000500020304060107081000020103020304070701060505000000010203000411122105314113225161061432718191c1334252a1b1d1f0231534728292e107354362732453a2b2f1010003010100000000000000000000000000010203041101010101000300020300000000000000000111021221310322415171ffda000c03010002110311003f00da46f9ab31bd0d8a4ab51bd74d8c4415b35229ced55237aeddddc7696ed2c87c801cd8f854e076fef3d5d0247bccfb20f0f3a7c42ead61433e655232c47b4befaa7c0eddee263c42ef7663fd31d31fb51eced4afaf4a91023abaea420a9f0a7542f6a43192d982b7553c8d28670cda2405241cd4fd29058069e2a3069e2903a9ace6119d0ec83f08c91f0a70dea1bebbf54897b34124f26d1a16c0f324f451d4d0619c4f8ec768354379223671d9c96a4e3e7a68037a47c4ef666486e174f8e9d214789aa3e975df6720b72feb37f38ef4adc917c157ee8f3e7f56f0d8234814bb7f4cefe7237ed5724c02cb732188c91b3b631aa661b9f70e828ec72092568e3624a8cb0c640acacd7ccefd84285bc42f218df04f8edcab51c3ca1b5468fda98e491d7271fa52e848b96b7663984729c8c73345ade6ca1c12df0a1105911333391a55bbb8df00eff5a2ab9d3a33dec774d67549164d5331c30db18c54fab3d0fcaa8dbdd3c923c2305d3da04e306aca48cdb00011cc66904d485372df876f1cd381a03b4a952a0152a54a8054a952a03cce292ae44f4222936abb13f2aebb198919d2189a49582a2a92493b015995e29fdab7ed2b645a4474a0cff39d54f4d66e21eac8b046dea7ce4913739e808f0acff0bbc316013dd3e7b53e79fe4afc7a95adf6749423481e345a1b80e84935e7dc37880122e3245692caf41d5bf218c5475c14ad02b8276a7491a4cb871cb7041dc50eb79c1daaf46f9acecc54a61692dfed7be9d1c7d6ac46436e0e6bb9cae2a3584c59301dbaa1e5f0a469b5c683bf228f7b62b35e9271b8ac2390d9af6b72fb2cafb841e59e75a192e822e021797a478dff00fcf3af3cf4aa5babb96e65d9d21461ab9220eb8fe6f473369b330ca6f2fa5b8bb725725a4727723afc49dab4dc2619f89b92434508e6579a8fc23cfc4fc3ceb2fc22137920854108b8772a799e607e95a4e1fc6ae6c21911acd8c311d2258943aeae9c8e7f2abb4f06a04885d18e0558e28bfa3181e3cddbe946783c613b38541d31ea7031d189d3f91359ce0f2c722b48f2a98a25c48fcb6072e7e276f81ad47096628d7122e9794ead2798cec07c062a298bc5bc8fe58fd29ddaea94c6367c6a4f3c123e955ed24ee5c4a4f7559b7f25dbe94d98958a2b94f6a2009f71c66a02ee849c899146b1b3676a9741ce4efe5fef548332dca5c42f98a75ef21e5a855f4d2774e5e1e1481e873c8b7f9a9fbf5c545236821b1dd3f953d1b50ca9c8a01e2953739a7668054a952a0152a54a80f1e8988abb1c9819276ababc2a251a9a52078900555e23c1ad6f55107100a14e746d863e66bafca2313c6eaebd1948e5cf34078cfa291cf9b8e1788a63bb45f71ff6347d2d0db622c634efeff3daac44a7c28dcf84f36b6967b3b836f751bc5327dd63cfdde55a6e197fad4b293ece37a3dc4785d8f1387b3bc0ba87b2c0f797dd59f8bd19bfb4b92b6f89e16e4ec74fce9f94bf4ac686c6e4b019233d7146eda5ce28370ee1d2db44166923dbc013fb5100d1c43db6ff00563f4acfac139a33182454c801e5f9566a5e22b1e707e673545b8aa06efb853cea3c57821e937158387cb0a070a1f2b8ea4fd6b1fe935f19781dd34449242a803cd80a31c6204478ae6ea07d5a0e824743eff79a152a477912c69b289118ae31ecb034fe1c49e8c7095b5b62b2005d882fe640fde99e96dec36b3416b022f6d8ed09e473c86fe1ccfc28bc732c0a00cb3fdd44dc9fe79ed597e34b1665bdb950788dc266388b656de11b6b3e27ea691a7e0d2c33ceb1425bd56321a67dc19dc7218f0adaf0cbf49a296f03661872a873b33f2cfc397cebcce199e1b148d329da8d312f266f163e5fad6bec6448ec85927f77b288cb39e85b1b2fbc9fd295369f84dc993d1d776392e187bf5311f5abd212f6971129c6bb4ca9f02338accfa2372f270092329a9a3c30539dc6acd1f691adaeadb0b980064724fb19c15cfcc8f85491fc2e52d6fdab06313e19d7ff006cfe21e5462df24f304f3041f6878d50b3411b04d8269d1a4722072a9c3fabdc22939523f31fc14a85ec8c956e47a1a4214ce57ba7c8d23de6d8f3a5aca1c30c0f1a40f03cf3e74e14b6db07634a80ed2a429500a952a54061e2e15683731127c4b1fdea5feceb31ff00447fa8d74dd22ed9a824bf41d47ceb7f74b167b0b7c28ecd70a303cabba205e51a7fa686c9c4d47223e7509e244f21465182ed32a8c2e00f015566bb51d77f1a1725dccfc86079d5729752fb21987fda29e1e2e5c710d3cb27dd43e6e2a49c2a39f80ae5c5adc47f688c0fbb9d56962d43bc307dd4f0d1cd75349b86d23cb9d0f33f66492761f9d3ee6531646ac8a1f0ba4f76892b695ddb738c9a607fd7afae6d63d72ea61b28907dde829d6f00130941d0fc9b47261e750a36db72ab56fceb3a05235664c2b2ae4778e2b297dd95dbcdeae035a44dae69e43dc761d58f33e43af4006f5a09217beffd36592dbfea9538327fda0f41e269bc52dec2cacd67bf506d20fb1b44d959fcff0011a90c299679af56551276927d933ae085f1c7ed5b18d12d2c6db86464979e4ed2e586fb004e3f2c7c0d651f89325dcbc42e46bb973850a70107451e1f4a2a2fae2222dd40ed193b5793aead3b01e034914c36dc3223c36745b96658a5b619279ff4f19fca8a4730b9ede75c94922560a7c31b7cab11c04cb25db09d99a6490e4bb64e92872b93d2b57c1df4401750cac0a323ae49c7e54ac21eb6933da263006349f853b8836b8a361c8f2f9550e153ab2b36d86543ff00c690ba0f631bb1f65c03f2c7d454e013b79d9a14639dc7c8d128dc48809dfc41e9432d9755b8317b49b63f12f43fcf0ab96fa7198c9d279a9e869509d50213a791e94fae0c1e55da40b35dae52a03b4a952a03c865e26ef9d39aa171c47b372b2c9861f7473a032dccb27b6ec478676a7da64c9dbc84b01b8cf8d77f8c5688dcf1530c0ce632ac480a5bf53466ca7896d11da559469c9914e14fcba5673d6cc61966412239df3512d82c80fa94f22c1211db5b86d987d29589ad0f0a9fd6aea5e23a7b346ee42b8c6a51f78fbe8ec570c48c9acdfaec56d6c5970ba06346318f0152f0ee2924f1ab3c1a0b1caa9246a5f11e353622c6b6391645d2ea1879d32ea1b648d9cdaccea06fd900df966a8585e2c8e11bb8fd54fd29d7be93da70bbd36b751c8360c245df20d67609a03c7070dfecc6e21019bb207bcb8190796fbed5887bfb3964035614ed871ceb6fe96c1c0b8df0d9ef6c2ee24b845d4ea1b4971e6bb6f5e657a6d5ae945ac4d1ae901959b3deea41f0a56d8d235363677b2471cbc39a5d123685eccea52de1efab97577c6b834cb15f42158eebdaa6323e1591b4bd9ed630d6f33a488da810791e747b88f1ebce356d692f10759248a320328dc8cf5f3a9dd092ebd28e2124d0988ac2616d594ce1bc883d28ad939f482e4c9c66f85b2c49954c11b75d3fccd63ad5f5cecea036860749eb5a596fe3e23eaf114447890ea006e7f7ab934aa2e2362672d77696ad15a6aeca15607bc48e64f53d6ac24ac389891b7ecd4314fc59df1efe43e1450decf75c3e0b4b940c9138656030d8c55311a24f72f211ccb6c799c6c07cff002a9cc1a9b824efdadcbbb65e5272478f218f9d692cef17b695626ee61557e1802b31c3eda578b443edb2b39f2500927e55b09f859b4e1b61322e0ead0fefc8c67f3a3d151008d0492c0980dd96a51e034e7f7a945b3daae89535c5b090788e8dfceb56dad48e31238195ec151bc707233458a2b819008c63e1e1516921e1c8625c03ae32329279781abd819c81bf53e354ede036ec5626fe8939d27ee9f2f2ab4a6a69a504d3b34c15d148cfa55c06bb407734ab82bb407ce66da4561a94af99a9718c201b0a22ac70549d4be069beacbab526c0f43d2bbd663db24d027438e63c6a8c90cd6b26a5eee37d428a0214046d8d4aa038c30d43ce8d4a847756f729d95fc6307ef8a371a8921ecdf0d17dd74e98f2a0d7d6b0409da6bd209c683f78f950d4e29776521482454f14f6cfcba52eac2cd6c20d0da4acf1ce10e46971a87efeea17ff001162d16f6978767de33fafef586b9bd2d2336fab355ae2e6e2e142b6b651c813b0f3acaf50fc711cf724e698855ca9cd42f1be77e5522ed802b2fa6b08bdf620edcaadc69dcd2588cf850e32e823152a5e1e581f1a7c92f5931e197d14d22074620e5b973a2e2c5a7669e193448c723036a151dc2c8816444607a519e1ed3c488220922e36463a5bdc0f235a48546b835c7aca147c09a33a5d7eb45a4e1f1dc282ab890726f1f2ac6dd5f35a7158ef2d8346ec312c122119f8f23f0ad870dbb5942cd11cc520c8cfe62925a3e01c2123e16eeca3b47b731edd324eafcb15a4b8b68e7b592dd8615b963ee9e791f1acefa3dc4585e7ab0cba49bedf7481cfe95a5d559dfa0e8d4eb591bdbecc2b7f3e75366a00d5d7992242f2300078d484e0d577e256b1cbd9bcc038e630683713e3456262874a7219d89acec37459b5336e4fceaf9fc7a9bdbd1a19e294651d5bdc6a51b564ac64962896541866e471d28ed97114980590e186d9f1a9bce2a74242bb4d534e150a2aed72bb407842ec2a40d9daaae964f65be06a4132852cfddd233e55deb4d86fbc352555bbbf10a18ed88321e44ef8aa7fda7dbb4bad5bb30309a4e0ff00b9aa52be9d41b61f814fea7e9517a83125ecd24f31796e32aa3482a31fcf850f94e418edd07bcd4a51a723bd803901b54aeb1d944348d521f1e9517d987a5a767dfb8c69e783d4d72eaf4ba145540391eee0fba9f24f23821b727ad5510976d28a49f01bd46ff4158ef4e48460b3b05f0041deafa5bba7d994d58ceb2790f2fdeb82d148d4666639e8338fce9ce52a3d9c64e199cfb8015208a0200119f3cb9ff6a926b66874b9c156380478d76de192e24114085d89c6053cf649ad6344c18e24ff00364fea6b4b63c36f9ac9ae277b5b3809c24b76446afee04ef505ac76dc2186cb757e0671ce387dfe26aca4d1dccc2e2fa4f5a9c8e6fdec7928e407baabfc211e1b69693f0a9d2faf2d66b857fe946b3a3a30dbaed83cfad5be11c3161b91690b3c51ccc311cbd09fbca4731f3a8a06fc2810019d38c55a8a446d9b033cc0e5f2faf3a9c4b7bc3786c1c361d108cb1f6a46e6d564b50de15c4e39a258e4601b1b12799ab374e506d51854eb8bc8e05c9ddb1cb3406eafe4b8932e761c80e4299c42e4e4efbd66b8df12f56b6ecd0e259761e43a9ad39e116e9dc4b888b9b9d08c0c71ec3ccd5be0d11beba5887b38cb9f01593825615e85e8bdbac16658307989feae93bc67c0f87ee7caafaf5139eda640ba0260691b01fcfe7ce9925a67bd11e5d2b90b0032b8f018fe7f3e156518e71d4fb46b9da1b6b7cf115490165a2b0cab2ae548c50e7892723c475a842c968d94279f2e869592aa5c1d14aa8db5f2489df2030e609a55194f5e0f149247b377bdf4af98cc8228f2abcdcd4afce992f26ffc9f4aecb7d340e64ecdb38c1fbabf87cfdf5135bb3efbd5d9fed0fbe92f2158dbef151088cc31646edd0540e8f264b0dcf5abf273a6ad3a41e2d0b677c0ea7c2ac436cba32a311f2391bb9f3f2ab63ecbe35345f603fc67f4a702bdadb4722c8d708ba15b0bab95437f144f0a2dbe9eebe48518daac5df4f7d747b11ff9be957a4a32583ce21b6424b1efb13f7474ebe66a67912c2236fc3c7f548c4930e63dd44787fda5c7bfe94322f6d7df4b49c82d5dc0d4342733beede744ad6048db08bf1a637b42aedbd34d5cb7c8ce4e76a7a9037a60fa5397952214b093277e55a7b791a5e1ea5c92572326b2563ed7c2b5165ff2e3fe23517ea6817149163123bb6154649ac25dcef7974d2bf227ba3c056bfd29fee171fe5fd456392b7e5320f7a2bc29efae8cacbfd38b7dfef3741459f87de70db937364f22b83dec1f6bc7de3caadfa0ff00f2a93ff2b7ff004a37c47fbb0ff11acef5fb1588b857198e72b0de28b79c743ec367f4346d58aaf5d677207e42b15c4fedfe06b5d61fdd2c3fc3f4351dcc3957d4e85c0e6799fe7caa7450460815557da5f855b8fe95955abcf67adb3100be39a55753ef7be951a31fffd9, '678245600132', 'Fernz Gate', 'Fernz Gate', 'Kemco', 1, 'English', 'Available', 1);

-- --------------------------------------------------------

--
-- Table structure for table `book_publication_info`
--

DROP TABLE IF EXISTS `book_publication_info`;
CREATE TABLE `book_publication_info` (
  `book_id` int(7) NOT NULL,
  `publication_name` varchar(100) NOT NULL,
  `publication_details` varchar(100) NOT NULL,
  `publication_website` varchar(100) NOT NULL,
  `publication_copyright_year` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_publication_info`
--

INSERT INTO `book_publication_info` (`book_id`, `publication_name`, `publication_details`, `publication_website`, `publication_copyright_year`) VALUES
(1, 'Kemco Publishing House Incorporated', 'Kemco Publishing House Incorporated', 'www.kemco.com', '2012');

-- --------------------------------------------------------

--
-- Table structure for table `book_purchase_info`
--

DROP TABLE IF EXISTS `book_purchase_info`;
CREATE TABLE `book_purchase_info` (
  `book_id` int(7) NOT NULL,
  `purchase_date` varchar(10) NOT NULL,
  `recieve_date` varchar(10) NOT NULL,
  `book_price` float(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book_purchase_info`
--

INSERT INTO `book_purchase_info` (`book_id`, `purchase_date`, `recieve_date`, `book_price`) VALUES
(1, '2017/10/03', '2017/10/04', 1937.99);

-- --------------------------------------------------------

--
-- Table structure for table `book_types`
--

DROP TABLE IF EXISTS `book_types`;
CREATE TABLE `book_types` (
  `type_id` int(3) NOT NULL,
  `types` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `book_types`
--

INSERT INTO `book_types` (`type_id`, `types`) VALUES
(1, 'Book'),
(2, 'Journals'),
(3, 'Magazine'),
(4, 'Newspaper');

-- --------------------------------------------------------

--
-- Table structure for table `borrower_list`
--

DROP TABLE IF EXISTS `borrower_list`;
CREATE TABLE `borrower_list` (
  `Issue_Code` int(11) NOT NULL,
  `Student_ID` int(11) NOT NULL,
  `Book_ID` int(11) NOT NULL,
  `Borrow_Date` varchar(50) NOT NULL,
  `Return_Date` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nigol_nimda`
--

DROP TABLE IF EXISTS `nigol_nimda`;
CREATE TABLE `nigol_nimda` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nigol_nimda`
--

INSERT INTO `nigol_nimda` (`username`, `password`) VALUES
('admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `staff_info`
--

DROP TABLE IF EXISTS `staff_info`;
CREATE TABLE `staff_info` (
  `StaffID` int(11) NOT NULL,
  `Staff_Name` varchar(100) NOT NULL,
  `Designation` varchar(100) NOT NULL,
  `Department` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_info`
--

INSERT INTO `staff_info` (`StaffID`, `Staff_Name`, `Designation`, `Department`) VALUES
(123, 'Staff No.1', 'Circulation', 'CCE');

-- --------------------------------------------------------

--
-- Table structure for table `staff_login`
--

DROP TABLE IF EXISTS `staff_login`;
CREATE TABLE `staff_login` (
  `Staff_ID` int(11) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff_login`
--

INSERT INTO `staff_login` (`Staff_ID`, `password`) VALUES
(123, 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
CREATE TABLE `student_info` (
  `Student_Name` varchar(100) NOT NULL,
  `Student_Year` int(2) NOT NULL,
  `Student_Course` varchar(100) NOT NULL,
  `Student_ID` int(11) NOT NULL,
  `Student_Gender` varchar(100) NOT NULL,
  `Student_Contact` varchar(20) NOT NULL,
  `Student_Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_info`
--

INSERT INTO `student_info` (`Student_Name`, `Student_Year`, `Student_Course`, `Student_ID`, `Student_Gender`, `Student_Contact`, `Student_Status`) VALUES
('Name 1', 1, 'BSCS', 442501, 'Male', '09123456789', 'Active'),
('Name 2', 2, 'BSIT', 442502, 'Female', '09123456789', 'Inactive'),
('Name 3', 3, 'BSCS', 442503, 'Male', '09123456789', 'Active'),
('Name 4', 4, 'BSIT', 442504, 'Female', '09123456789', 'Inactive'),
('Name 5', 2, 'BSCS', 442505, 'Male', '09123456789', 'Active'),
('Name 6', 3, 'BSIT', 442506, 'Female', '09123456789', 'Inactive'),
('Name 7', 4, 'BSCS', 442507, 'Male', '09123456789', 'Active'),
('Name 8', 1, 'BSLIS', 442508, 'Female', '09123456789', 'Inactive'),
('Name 9', 3, 'BSCS', 442509, 'Male', '09123546789', 'Active'),
('Name 10', 2, 'BSIS', 442510, 'Female', '09123456789', 'Inactive'),
('Name 11', 4, 'BSCS', 442511, 'Male', '09123456789', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `transactionhistory`
--

DROP TABLE IF EXISTS `transactionhistory`;
CREATE TABLE `transactionhistory` (
  `Issue_Code` int(11) NOT NULL,
  `Book_ID` int(11) NOT NULL,
  `Student_ID` int(11) NOT NULL,
  `Staff_ID` int(11) NOT NULL,
  `Transaction_Type` varchar(50) NOT NULL,
  `borrow_date` varchar(10) NOT NULL,
  `due_date` varchar(15) DEFAULT NULL,
  `return_date` varchar(10) NOT NULL,
  `Late_Fee` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionhistory`
--

INSERT INTO `transactionhistory` (`Issue_Code`, `Book_ID`, `Student_ID`, `Staff_ID`, `Transaction_Type`, `borrow_date`, `due_date`, `return_date`, `Late_Fee`) VALUES
(1, 1, 442501, 123, 'Return Book', '2017/10/04', '2017/10/11', '2017/10/12', '50'),
(2, 1, 442501, 123, 'Return Book', '2017/10/04', '2017/10/22', '2017/10/31', '450');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `cat_id` (`cat_id`),
  ADD KEY `subcat_id` (`subcat_id`);

--
-- Indexes for table `book_categories`
--
ALTER TABLE `book_categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `book_info`
--
ALTER TABLE `book_info`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `book_publication_info`
--
ALTER TABLE `book_publication_info`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `book_purchase_info`
--
ALTER TABLE `book_purchase_info`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `book_types`
--
ALTER TABLE `book_types`
  ADD PRIMARY KEY (`type_id`);

--
-- Indexes for table `borrower_list`
--
ALTER TABLE `borrower_list`
  ADD PRIMARY KEY (`Issue_Code`),
  ADD KEY `Student_ID` (`Student_ID`),
  ADD KEY `Book_ID` (`Book_ID`);

--
-- Indexes for table `nigol_nimda`
--
ALTER TABLE `nigol_nimda`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `staff_info`
--
ALTER TABLE `staff_info`
  ADD PRIMARY KEY (`StaffID`);

--
-- Indexes for table `staff_login`
--
ALTER TABLE `staff_login`
  ADD PRIMARY KEY (`Staff_ID`);

--
-- Indexes for table `student_info`
--
ALTER TABLE `student_info`
  ADD PRIMARY KEY (`Student_ID`);

--
-- Indexes for table `transactionhistory`
--
ALTER TABLE `transactionhistory`
  ADD PRIMARY KEY (`Issue_Code`),
  ADD KEY `transactionhistory_ibfk_1` (`Book_ID`),
  ADD KEY `Student_ID` (`Student_ID`),
  ADD KEY `Staff_ID` (`Staff_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_info`
--
ALTER TABLE `book_info`
  MODIFY `book_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=442503;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `book_types` (`type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `book_ibfk_3` FOREIGN KEY (`cat_id`) REFERENCES `book_categories` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `book_ibfk_4` FOREIGN KEY (`subcat_id`) REFERENCES `book_categories` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `book_ibfk_5` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`);

--
-- Constraints for table `book_publication_info`
--
ALTER TABLE `book_publication_info`
  ADD CONSTRAINT `book_publication_info_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `book_purchase_info`
--
ALTER TABLE `book_purchase_info`
  ADD CONSTRAINT `book_purchase_info_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `staff_login`
--
ALTER TABLE `staff_login`
  ADD CONSTRAINT `staff_login_ibfk_1` FOREIGN KEY (`Staff_ID`) REFERENCES `staff_info` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `transactionhistory`
--
ALTER TABLE `transactionhistory`
  ADD CONSTRAINT `transactionhistory_ibfk_1` FOREIGN KEY (`Book_ID`) REFERENCES `book` (`book_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `transactionhistory_ibfk_2` FOREIGN KEY (`Student_ID`) REFERENCES `student_info` (`Student_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `transactionhistory_ibfk_3` FOREIGN KEY (`Staff_ID`) REFERENCES `staff_info` (`StaffID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
