-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 09 avr. 2021 à 00:26
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `imane_shop`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE `articles` (
  `CodeArticle` int(25) NOT NULL,
  `Designation` text NOT NULL,
  `Prix` double NOT NULL,
  `Stock` int(25) NOT NULL,
  `Categorie` int(25) NOT NULL,
  `photo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `articles`
--

INSERT INTO `articles` (`CodeArticle`, `Designation`, `Prix`, `Stock`, `Categorie`, `photo`) VALUES
(1, 'Talon Rouge', 120, 15, 1, 'img/H1.jpg'),
(2, 'Talon Jaune', 133, 10, 1, 'img/im.jpg'),
(3, 'Robe Noire', 250, 2, 2, 'img/D1.jpg'),
(4, 'Robe Rose', 300, 1, 2, 'img/D2.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE `categories` (
  `RefCat` int(25) NOT NULL,
  `Cat` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`RefCat`, `Cat`) VALUES
(1, 'Heels'),
(2, 'Dresses');

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `Id` int(25) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Nom` varchar(25) NOT NULL,
  `Prenom` varchar(25) NOT NULL,
  `Adresse` varchar(100) NOT NULL,
  `CodePostal` int(25) NOT NULL,
  `Ville` varchar(30) NOT NULL,
  `Tel` varchar(30) NOT NULL,
  `userName` varchar(30) NOT NULL,
  `password` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `clients`
--

INSERT INTO `clients` (`Id`, `Email`, `Nom`, `Prenom`, `Adresse`, `CodePostal`, `Ville`, `Tel`, `userName`, `password`) VALUES
(1, 'im@im.im', 'im', 'uÃ¹', 'hjkkju', 154, 'drt', '02', '', 1999),
(3, 'imane.5@gm.com', 'IMANE', 'EL KADIMI', 'guÃ©liz', 5555, 'Marrakech', '06666', '', 1999),
(4, 'im@op.m', 'k', 'm', 'l', 5, 'm', '06', 'imane', 123456),
(5, 'im@pm.ml', 'EL KADIMI', 'IMANE', 'GUELIZ', 5555, 'MARRAKECH', '06666666666', 'IMANE', 159951),
(6, 'm@m.n', 'kl', 'mp', 'hjk', 55, 'hhjjgg', '05', 'mo', 147258),
(7, 'n@h.m', 'lh', 'h', 'h', 5, 'h', '00', 'ha', 147147),
(8, 'ss@gm.com', 'kk', 'ss', 'dfg', 123, 'mrk', '233', 'Said', 123456),
(9, 'k@l.v', 'BSK', 'S', 'guy', 225, 'kech', '055', 'SANAA', 147258),
(10, 'kil@kl.m', 'kiki', 'nono', 'lili', 1111, 'kech', '0157', 'Em', 456789),
(11, 'hj@o.com', 'EL KAD', 'imane', 'guel', 5555, 'kech', '0666', 'IMAAANE', 789456),
(12, 'k@m.p', 'm', 'kk', 'lml', 56, 'kech', '025', 'immm', 159159),
(13, 'k@p.f', 'ima', 'ne', 'kgl', 5, 'gk', '5', 'oui', 159159),
(14, 'n@j.v', 'M', 'A', 'SB', 225, 'A', '1158', 'MIN', 123456);

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE `commandes` (
  `NumCom` int(25) NOT NULL,
  `CodeClient` int(25) DEFAULT NULL,
  `DateCommande` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `lignescommandes`
--

CREATE TABLE `lignescommandes` (
  `NumCom` int(25) NOT NULL,
  `CodeArticle` int(25) NOT NULL,
  `QteCde` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`CodeArticle`),
  ADD KEY `FOREIGN KEY` (`Categorie`) USING BTREE;

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`RefCat`);

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `unique` (`Email`);

--
-- Index pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`NumCom`),
  ADD KEY `CodeClient` (`CodeClient`);

--
-- Index pour la table `lignescommandes`
--
ALTER TABLE `lignescommandes`
  ADD PRIMARY KEY (`NumCom`,`CodeArticle`),
  ADD KEY `FOREIGN KEY` (`CodeArticle`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `Id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `articles`
--
ALTER TABLE `articles`
  ADD CONSTRAINT `Categorie` FOREIGN KEY (`Categorie`) REFERENCES `categories` (`RefCat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `commandes_ibfk_3` FOREIGN KEY (`NumCom`) REFERENCES `lignescommandes` (`NumCom`);

--
-- Contraintes pour la table `lignescommandes`
--
ALTER TABLE `lignescommandes`
  ADD CONSTRAINT `FK` FOREIGN KEY (`NumCom`) REFERENCES `commandes` (`NumCom`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FOREIGN KEY` FOREIGN KEY (`CodeArticle`) REFERENCES `articles` (`CodeArticle`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
